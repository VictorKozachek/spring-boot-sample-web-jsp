package ru.schoolarlife.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.schoolarlife.logic.bl.location.interfaeces.LocationService;
import ru.schoolarlife.logic.bl.person.interfaces.ParentService;
import ru.schoolarlife.logic.bl.person.interfaces.StudentService;
import ru.schoolarlife.logic.bl.person.interfaces.TeacherService;
import ru.schoolarlife.logic.bl.security.interfaces.RoleService;
import ru.schoolarlife.logic.bl.security.interfaces.SecurityService;
import ru.schoolarlife.logic.bl.security.interfaces.UserService;
import ru.schoolarlife.logic.bl.security.validation.UserValidator;
import ru.schoolarlife.logic.bo.person.Parent;
import ru.schoolarlife.logic.bo.person.Person;
import ru.schoolarlife.logic.bo.person.Student;
import ru.schoolarlife.logic.bo.security.Role;
import ru.schoolarlife.logic.bo.security.User;
import ru.schoolarlife.logic.bo.signup.Signup;
import ru.schoolarlife.logic.bo.signup.SignupResult;

import java.util.HashSet;
import java.util.Set;

/**
 * @author val.rudi
 */
@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ParentService parentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private LocationService locationService;

    @GetMapping
    public String singupView() {
        return "singup";
    }

    @PostMapping
    public SignupResult signup(@RequestBody Signup signup) {
        Person person = signup.getPerson();
        if (person instanceof Parent) {
            // TODO: register Parent and User for parent
        } else {
            // TODO: other units
        }
        // TODO: can use headers for client success messages
        return new SignupResult();
    }

    @PostMapping("/verification")
    public String signup(@RequestParam String code) {
        // TODO: verify code. if verified, then move to SuccessfulRegistration

        return "verification";
    }





    @RequestMapping(value = "/security/register", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        Set<Student> testStudent = studentService.findAllByFirstName("Василий");
     /*   Student testStudent = new Student();
        testStudent.setBirthDate(new Date(123556748));
        testStudent.setAge(10);
        testStudent.setFirstName("Василий");
        testStudent.setMiddleName("Алибабаевич");
        testStudent.setLastName("Кыргызстанов");
        testStudent.setGender(Gender.MALE);
        testStudent.setPhone("+79787774412");


        City city = locationService.findCityByName("Симферополь");

        Country country = locationService.findCountryByName("Российская Федерация");

        Address studentAddress = new Address("295000", country, city, "Киевская 37 кв.10", "Test student 2");
        studentAddress = locationService.saveAddress(studentAddress);


        testStudent.setAddress(studentAddress);
        studentService.save(testStudent);*/

        return "security/register";
    }

    @RequestMapping(value = "/security/register", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "security/register";
        }

        if(userForm.getRoles() == null || userForm.getRoles().size() <= 0)
        {
            Role defaultRole = roleService.findByName("Default");
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(defaultRole);
            userForm.setRoles(roleSet);
        }
        userService.save(userForm);

        securityService.autologin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "redirect:/main";
    }

}
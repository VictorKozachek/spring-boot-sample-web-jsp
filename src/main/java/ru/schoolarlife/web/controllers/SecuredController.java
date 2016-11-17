package ru.schoolarlife.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.schoolarlife.logic.bl.location.interfaeces.LocationService;
import ru.schoolarlife.logic.bl.person.interfaces.ParentService;
import ru.schoolarlife.logic.bl.security.CustomUserDetails;
import ru.schoolarlife.logic.bl.security.interfaces.RoleService;
import ru.schoolarlife.logic.bl.security.interfaces.SecurityService;
import ru.schoolarlife.logic.bl.security.interfaces.UserService;
import ru.schoolarlife.logic.bl.security.validation.UserValidator;
import ru.schoolarlife.logic.bl.person.interfaces.StudentService;
import ru.schoolarlife.logic.bl.person.interfaces.TeacherService;
import ru.schoolarlife.logic.bo.person.Student;
import ru.schoolarlife.logic.bo.security.Role;
import ru.schoolarlife.logic.bo.security.User;
import ru.schoolarlife.logic.model.dao.repositories.security.RoleRepository;
import ru.schoolarlife.logic.model.dao.repositories.security.UserRepository;

import java.util.*;

/**
 * @author val.rudi
 */
@Controller
public class SecuredController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //@Autowired
    //private SecurityService securityService;

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

    @Autowired()
    UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


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
            Role defaultRole = roleRepository.findByName("ROLE_PARENT");
            if (defaultRole == null)
            {
                defaultRole = new Role();
                defaultRole.setName("ROLE_PARENT");
                defaultRole = roleRepository.save(defaultRole);
            }
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(defaultRole);
            userForm.setRoles(roleSet);
        }
        userRepository.save(userForm);

        //securityService.autologin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "redirect:/main";
    }

    @RequestMapping(value = "/security/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        model.addAttribute("userForm", new User());
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "security/login";
    }

    @RequestMapping(value = "/security/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(userForm.getEmail());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, userForm.getPassword(), userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            //logger.debug(String.format("Auto login %s successfully!", username));
        }
        return "redirect:/main";
    }

    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "main";
    }

}
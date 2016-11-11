package ru.schoolarlife.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.schoolarlife.logic.bl.location.interfaeces.LocationService;
import ru.schoolarlife.logic.bl.security.interfaces.RoleService;
import ru.schoolarlife.logic.bl.security.interfaces.SecurityService;
import ru.schoolarlife.logic.bl.security.interfaces.UserService;
import ru.schoolarlife.logic.bl.security.validation.UserValidator;
import ru.schoolarlife.logic.bl.students.interfaces.StudentService;
import ru.schoolarlife.logic.bo.location.Address;
import ru.schoolarlife.logic.bo.location.City;
import ru.schoolarlife.logic.bo.location.Country;
import ru.schoolarlife.logic.bo.person.Student;
import ru.schoolarlife.logic.bo.security.Role;
import ru.schoolarlife.logic.bo.security.User;
import ru.schoolarlife.logic.helpers.Gender;
import ru.schoolarlife.logic.model.dao.repositories.RoleRepository;

import java.util.*;

/**
 * @author val.rudi
 */
@Controller
public class SecuredController {
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
    private LocationService locationService;


    @RequestMapping(value = "/security/register", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        Student testStudent = studentService.findByFirstName("Василий");
      /*  testStudent.setBirthDate(new Date(123456748));
        testStudent.setAge(10);
        testStudent.setFirstName("Василий");
        testStudent.setMiddleName("Васильевич");
        testStudent.setLastName("Пупкин");
        testStudent.setGender(Gender.MALE);
        testStudent.setPhone("+79787774411");


        City city = new City("Симферополь");
        city = locationService.saveCity(city);

        Country country = new Country("Российская Федерация");
        country = locationService.saveCountry(country);

        Address studentAddress = new Address("295000", country, city, "Воровского 12 кв.5", "Test student");
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

    @RequestMapping(value = "/security/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "security/login";
    }

    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "main";
    }

}
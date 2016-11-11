package ru.schoolarlife.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.schoolarlife.logic.bl.lifecycle.interfaces.AbsencesService;
import ru.schoolarlife.logic.bl.lifecycle.interfaces.AssessmentService;
import ru.schoolarlife.logic.bl.lifecycle.interfaces.SchoolClassService;
import ru.schoolarlife.logic.bl.lifecycle.interfaces.SubjectService;
import ru.schoolarlife.logic.bl.location.interfaeces.LocationService;
import ru.schoolarlife.logic.bl.person.interfaces.ParentService;
import ru.schoolarlife.logic.bl.person.interfaces.StudentService;
import ru.schoolarlife.logic.bl.person.interfaces.TeacherService;
import ru.schoolarlife.logic.bl.security.interfaces.RoleService;
import ru.schoolarlife.logic.bl.security.interfaces.SecurityService;
import ru.schoolarlife.logic.bl.security.interfaces.UserService;
import ru.schoolarlife.logic.bl.security.validation.UserValidator;
import ru.schoolarlife.logic.bo.person.Student;
import ru.schoolarlife.logic.bo.security.User;

import java.util.Set;

/**
 * Created by victor on 11.11.16.
 */
@Controller
public class TestController {
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


    @Autowired
    private AbsencesService absencesService;

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private SchoolClassService schoolClassService;

    @Autowired
    private SubjectService subjectService;

    private Model model;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testModels(Model model) {
        this.model = model;
        model.addAttribute("message", "Tester");

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

        return "test";
    }
}

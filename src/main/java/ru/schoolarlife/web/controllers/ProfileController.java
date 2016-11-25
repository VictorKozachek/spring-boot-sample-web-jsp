package ru.schoolarlife.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import ru.schoolarlife.logic.bo.person.Parent;
import ru.schoolarlife.logic.bo.person.Student;
import ru.schoolarlife.logic.bo.person.Teacher;


import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;

/**
 * Created by victor on 22.11.16.
 */
@Controller
public class ProfileController {

    @RequestMapping("/ajax")
    public ModelAndView helloAjaxTest() {
        return new ModelAndView("ajax", "message", "Crunchify Spring MVC with Ajax and JQuery Demo..");
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    public @ResponseBody
    String getTime() {

        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
        return result;
    }


    @GetMapping("/addprofile/{profileType}")
    public String editProfile(@PathVariable("profileType") Integer profileType, Model model) {
        switch (profileType)
        {
            case 0:
            {
                model.addAttribute("userProfile", new Parent());
            }
            case 1:
            {
                model.addAttribute("userProfile", new Teacher());
            }
            case 2:
            {
                model.addAttribute("userProfile", new Student());
            }
            default:
            {
                model.addAttribute("userProfile", new Parent());
            }
        }
        model.addAttribute("userForm", new Parent());
        return "person/editprofile";
    }

    @RequestMapping(value = "/jqtest", method = RequestMethod.GET)
    public String jqCheck(Model model) {
        return "jqcheck";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadProfilePicture(@RequestParam("uploadfile") MultipartFile uploadfile) {

        try {
            // Get the filename and build the local file path (be sure that the
            // application have write permissions on such directory)
            String filename = uploadfile.getOriginalFilename();
            String directory = "/home/victor/Pictures/1";
            String filepath = Paths.get(directory, filename).toString();

            // Save the file locally
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(uploadfile.getBytes());
            stream.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "person/editprofile";
        }

        return "person/editprofile";
    }


    @RequestMapping("/upfile")
    public String index() {
        return "upload";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            String content = new String(file.getBytes());
            return "file name:" + file.getOriginalFilename() + "<br> content:" + content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "file name:" + file.getOriginalFilename() +"<br> read file content error.";
    }
}

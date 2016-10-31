package sample.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * @author val.rudi
 */
@Controller
public class SecuredController {

    @RequestMapping("/security/login")
    public String login(Map<String, Object> model) {
        model.put("time", new Date());
        return "security/login";
    }
}
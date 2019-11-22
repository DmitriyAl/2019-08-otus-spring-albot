package otus.spring.albot.lesson20.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping(value = "login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "loginError")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}

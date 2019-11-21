package otus.spring.albot.lesson14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NavbarController {
    @GetMapping("/changeLanguage")
    public String changeLanguage(@RequestParam("lang") String lang, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("lang", lang);
        return "redirect:/orders";
    }
}

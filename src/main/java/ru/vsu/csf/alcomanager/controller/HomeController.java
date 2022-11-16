package ru.vsu.csf.alcomanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vsu.csf.alcomanager.config.WebSecurityConfig;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/about")
    public String getPage(Principal principal, Model model) {
        if (principal != null) {
            User currUser = userService.getByLogin(principal.getName());
            model.addAttribute("user", currUser);
//            System.out.println(currUser);
        }
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
        return "user/profile";
    }
}

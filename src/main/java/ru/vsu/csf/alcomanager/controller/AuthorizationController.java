package ru.vsu.csf.alcomanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.config.WebSecurityConfig;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class AuthorizationController {

    private final UserService userService;

    @PostMapping()
    public String reg(@RequestParam String login,
                      @RequestParam String password,
                      @RequestParam String name,
                      @RequestParam String surname,
                      Principal principal,
                      Model model) {
        if (principal != null) {
            User user = userService.getByLogin(login);
            model.addAttribute("user", user);
        }
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
        User user = new User(login, password, name, surname);
        if (!userService.addUser(user)) {
            model.addAttribute("error", "Неверный логин или пароль");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping()
    public String registrationGet(Principal principal, Model model) {
        if (principal != null) {
            User currUser = userService.getByLogin(principal.getName());
            model.addAttribute("currUser", currUser);
        }
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());

        return "registration";
    }
}

package ru.vsu.csf.alcomanager.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vsu.csf.alcomanager.config.WebSecurityConfig;
import ru.vsu.csf.alcomanager.model.Alcohol;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.service.AlcoholService;
import ru.vsu.csf.alcomanager.service.UserService;

import java.security.Principal;
import java.util.List;
//
//@Controller
//@RequestMapping("/user/alcohol")
//@AllArgsConstructor
public class UserAlcoholController {
//    private final UserService userService;
//    private final AlcoholService alcoholService;
//
//    @GetMapping()
//    public String getPage(Principal principal, Model model) {
//        if (principal != null) {
//            User currUser = userService.getByLogin(principal.getName());
//            model.addAttribute("user", currUser);
//        }
//        List<Alcohol> alcoholList =alcoholService.findAll();
//        model.addAttribute("alcohols", alcoholList);
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//        return "user/alcohol";
//    }
//
//    @PostMapping("/like/{id}")
//    public String likeAlcohol(@PathVariable("id") Long id,
//                           Principal principal,
//                           Model model){
//        if (principal != null) {
//            User currUser = userService.getByLogin(principal.getName());
//            model.addAttribute("user", currUser);
//            userService.likeAlco(currUser.getId(), id);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//        return "redirect:/user/alcohol";
//    }
//
//    @PostMapping("/dislike/{id}")
//    public String dislikeAlcohol(@PathVariable("id") Long id,
//                              Principal principal,
//                              Model model){
//        if (principal != null) {
//            User currUser = userService.getByLogin(principal.getName());
//            model.addAttribute("user", currUser);
//            userService.disLikeAlco(currUser.getId(), id);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//        return "redirect:/user/alcohol";
//    }
}

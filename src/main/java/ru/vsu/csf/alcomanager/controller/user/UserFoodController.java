package ru.vsu.csf.alcomanager.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vsu.csf.alcomanager.config.WebSecurityConfig;
import ru.vsu.csf.alcomanager.model.Food;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.service.FoodService;
import ru.vsu.csf.alcomanager.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user/food")
@AllArgsConstructor
public class UserFoodController {
//    private final UserService userService;
//    private final FoodService foodService;
//
//    @GetMapping()
//    public String getPage(Principal principal, Model model) {
//        if (principal != null) {
//            User currUser = userService.getByLogin(principal.getName());
//            model.addAttribute("user", currUser);
//        }
//        List<Food> foodList = foodService.findAll();
//        model.addAttribute("foods", foodList);
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//        return "user/food";
//    }
//
//    @PostMapping("/like/{id}")
//    public String likeFood(@PathVariable("id") Long id,
//                           Principal principal,
//                           Model model){
//        if (principal != null) {
//            User currUser = userService.getByLogin(principal.getName());
//            model.addAttribute("user", currUser);
//            userService.likeFood(currUser.getId(), id);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//        return "redirect:/user/food";
//    }
//
//    @PostMapping("/dislike/{id}")
//    public String dislikeFood(@PathVariable("id") Long id,
//                           Principal principal,
//                           Model model){
//        if (principal != null) {
//            User currUser = userService.getByLogin(principal.getName());
//            model.addAttribute("user", currUser);
//            userService.disLikeFood(currUser.getId(), id);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//        return "redirect:/user/food";
//    }
}

package ru.vsu.csf.alcomanager.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.config.WebSecurityConfig;
import ru.vsu.csf.alcomanager.model.Food;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.service.FoodService;
import ru.vsu.csf.alcomanager.service.UserService;

import java.security.Principal;

//@Controller
//@RequestMapping("/admin/food")
//@AllArgsConstructor
//public class AdminFoodController {
//
//    UserService userService;
//    FoodService foodService;
//
//    @GetMapping()
//    public String getPage(Principal principal, Model model) {
//        if (principal != null) {
//            User currUser = userService.getByLogin(principal.getName());
//            model.addAttribute("user", currUser);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//        return "admin/food";
//    }
//
//    @PostMapping()
//    public String addAlcohol(@RequestParam String name,
//                             Principal principal,
//                             Model model) {
//        if (principal != null) {
//            User user = userService.getByLogin(principal.getName());
//            model.addAttribute("user", user);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//
//        foodService.addFood(new Food(name));
//        return "admin/food";
//    }
//}

@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class AdminFoodController {

    UserService userService;
    FoodService foodService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity addFood(@RequestBody Food food) {
        if(foodService.addFood(food)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}

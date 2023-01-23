package ru.vsu.csf.alcomanager.controller.admin;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.config.WebSecurityConfig;
import ru.vsu.csf.alcomanager.model.Alcohol;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.service.AlcoholService;
import ru.vsu.csf.alcomanager.service.UserService;

import java.security.Principal;

//@Controller
//@RequestMapping("/admin/alcohol")
//@AllArgsConstructor
//public class AdminAlcoholController {
//    AlcoholService alcoholService;
//    UserService userService;
//
//    @GetMapping()
//    public String getPage(Principal principal, Model model) {
//        if (principal != null) {
//            User currUser = userService.getByLogin(principal.getName());
//            model.addAttribute("user", currUser);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//        return "admin/alcohol";
//    }
//
//    @PostMapping()
//    public String addAlcohol(@RequestParam String name,
//                             @RequestParam String strength,
//                             Principal principal,
//                             Model model) {
//        if (principal != null) {
//            User user = userService.getByLogin(principal.getName());
//            model.addAttribute("user", user);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//
//        alcoholService.addAlcohol(new Alcohol(name, Integer.parseInt(strength)));
//        return "admin/alcohol";
//    }
//}

@RestController
@RequestMapping("/alcohol")
@AllArgsConstructor
public class AdminAlcoholController {
    AlcoholService alcoholService;
    UserService userService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity addAlcohol(@RequestBody Alcohol alcohol) {
        if(alcoholService.addAlcohol(alcohol)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
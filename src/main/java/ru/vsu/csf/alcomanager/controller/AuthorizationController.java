package ru.vsu.csf.alcomanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.model.SignInForm;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.service.UserService;
//
//@Controller
//@RequestMapping("/registration")
//@AllArgsConstructor
//public class AuthorizationController {
//
//    private final UserService userService;
//
//    @PostMapping()
//    public String reg(@RequestParam String login,
//                      @RequestParam String password,
//                      @RequestParam String name,
//                      @RequestParam String surname,
//                      Principal principal,
//                      Model model) {
//        if (principal != null) {
//            User user = userService.getByLogin(login);
//            model.addAttribute("user", user);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//        User user = new User(login, password, name, surname);
//        if (!userService.addUser(user)) {
//            model.addAttribute("error", "Неверный логин или пароль");
//            return "registration";
//        }
//        return "redirect:/login";
//    }
//
//    @GetMapping()
//    public String registrationGet(Principal principal, Model model) {
//        if (principal != null) {
//            User currUser = userService.getByLogin(principal.getName());
//            model.addAttribute("currUser", currUser);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//
//        return "registration";
//    }
//}

@RestController
@AllArgsConstructor
public class AuthorizationController {
    private final UserService userService;

    @CrossOrigin
    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody User user) {
        if (!userService.addUser(user)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ошибка регистрации");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/signIn")
    @ResponseBody
    public ResponseEntity signIn(@RequestBody SignInForm signInForm) {
        if(userService.authorize(signInForm)){
            User user = userService.getByUsername(signInForm.getUsername());
            return new ResponseEntity(user, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}

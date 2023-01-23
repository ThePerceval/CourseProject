package ru.vsu.csf.alcomanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.dto.SignInDTO;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.service.UserService;

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
    public ResponseEntity signIn(@RequestBody SignInDTO signInForm) {
        if(userService.authorize(signInForm)){
            User user = userService.getByUsername(signInForm.getUsername());
            return new ResponseEntity(user, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}

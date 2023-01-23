package ru.vsu.csf.alcomanager.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.model.Alcohol;
import ru.vsu.csf.alcomanager.service.AlcoholService;
import ru.vsu.csf.alcomanager.service.UserService;

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
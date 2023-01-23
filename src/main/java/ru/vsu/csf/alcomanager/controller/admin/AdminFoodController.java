package ru.vsu.csf.alcomanager.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.model.Food;
import ru.vsu.csf.alcomanager.service.FoodService;
import ru.vsu.csf.alcomanager.service.UserService;


@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class AdminFoodController {
    UserService userService;
    FoodService foodService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity addFood(@RequestBody Food food) {
        if (foodService.addFood(food)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}

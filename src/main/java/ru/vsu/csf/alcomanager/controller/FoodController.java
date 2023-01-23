package ru.vsu.csf.alcomanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.model.Food;
import ru.vsu.csf.alcomanager.service.FoodService;
import ru.vsu.csf.alcomanager.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class FoodController {
    private final FoodService foodService;
    private final UserService userService;

    @CrossOrigin
    @GetMapping()
    @ResponseBody
    public ResponseEntity getAllFood() {
        List<Food> food = foodService.findAll();
        if(food != null){
            return new ResponseEntity(food, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping("/like")
    public ResponseEntity likeFood(@RequestParam long userId,
                                   @RequestParam long foodId) {
        userService.likeFood(userId, foodId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/dislike")
    public ResponseEntity dislikeFood(@RequestParam long userId,
                                      @RequestParam long foodId) {
        userService.disLikeFood(userId, foodId);
        return new ResponseEntity(HttpStatus.OK);
    }
}

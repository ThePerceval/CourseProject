package ru.vsu.csf.alcomanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.model.Alcohol;
import ru.vsu.csf.alcomanager.service.AlcoholService;
import ru.vsu.csf.alcomanager.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/alcohol")
@AllArgsConstructor
public class AlcoholController {
    private final AlcoholService alcoholService;
    private final UserService userService;

    @CrossOrigin
    @GetMapping()
    @ResponseBody
    public ResponseEntity getAllAlcohol() {
        List<Alcohol> alcohol = alcoholService.findAll();
        if(alcohol != null){
            return new ResponseEntity(alcohol, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping("/like")
    public ResponseEntity likeAlco(@RequestParam long userId,
                                   @RequestParam long alcoholId) {
        userService.likeAlco(userId, alcoholId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/dislike")
    public ResponseEntity dislikeAlco(@RequestParam long userId,
                                      @RequestParam long alcoholId) {
        userService.disLikeAlco(userId, alcoholId);
        return new ResponseEntity(HttpStatus.OK);
    }
}

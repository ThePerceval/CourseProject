package ru.vsu.csf.alcomanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.csf.alcomanager.model.Alcohol;
import ru.vsu.csf.alcomanager.model.User;

import java.util.Set;

@RestController
@RequestMapping("/tmp11")
public class TmpController {

    @GetMapping()
    public User getPage() {
        User user = new User();
        user.setName("tmp_name");
        user.setUsername("username");
        user.setAlcohols(Set.of(new Alcohol()));
        System.out.println("tmp");
        return user;
    }
}

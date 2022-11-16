package ru.vsu.csf.alcomanager.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.config.WebSecurityConfig;
import ru.vsu.csf.alcomanager.model.Party;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.service.PartyService;
import ru.vsu.csf.alcomanager.service.UserService;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequestMapping("/user/party")
@AllArgsConstructor
public class UserPartyController {
    private final UserService userService;
    private final PartyService partyService;

    /**
     * Возвращает страницу создания вечеринки
     **/
    @GetMapping("/new")
    public String getCreatePage(Principal principal,
                                Model model) {
        if (principal != null) {
            User currUser = userService.getByLogin(principal.getName());
            model.addAttribute("user", currUser);
        }
        model.addAttribute("currDate", LocalDateTime.now());
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
        return "user/newParty";
    }

    /**
     * Возвращает страницу присоединения к вечеринке
     **/
    @GetMapping("/join")
    public String joinParty(Principal principal,
                            Model model) {
        if (principal != null) {
            User currUser = userService.getByLogin(principal.getName());
            model.addAttribute("user", currUser);
        }
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
        return "user/joinParty";
    }

    /**
     * Возвращает страницу со списком вечеринок пользователя
     **/
    @GetMapping()
    public String getParties(Principal principal,
                             Model model) {
        if (principal != null) {
            User currUser = userService.getByLogin(principal.getName());
            model.addAttribute("user", currUser);
            model.addAttribute("parties", currUser.getParties());
        }
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
        return "user/parties";
    }

    /**
     * Возвращает страницу конкретной вечеринки
     **/
    @GetMapping("/{id}")
    public String getParty(@PathVariable String id,
                           Principal principal,
                           Model model) {
        if (principal != null) {
            User currUser = userService.getByLogin(principal.getName());
            model.addAttribute("user", currUser);
            Party party = userService.getPartyById(currUser.getId(), Long.parseLong(id));
            model.addAttribute("party", party);
        }
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
        return "user/party";
    }

    /**
     * Обрабатывает форму создания вечеринки
     **/
    @PostMapping("/create")
    public String addParty(@RequestParam String name,
                           @RequestParam String place,
                           @RequestParam String date,
                           @RequestParam String password,
                           Principal principal,
                           Model model) {
        if (principal != null) {
            User user = userService.getByLogin(principal.getName());
            model.addAttribute("user", user);
        }
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());

        String pattern = "yyyy-MM-dd'T'HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        Party party = new Party(name, password, place, dateTime);
        partyService.addParty(party);
        if (principal != null) {
            User user = userService.getByLogin(principal.getName());
            userService.joinParty(user.getId(), party.getId());
        }
        return "redirect:/user/party";
    }

    /**
     * Обрабатывает форму присоединения к вечеринке
     **/
    @PostMapping("/join")
    public String inviteParty(@RequestParam String id,
                              @RequestParam String password,
                              Principal principal,
                              Model model) {
        if (principal != null) {
            User user = userService.getByLogin(principal.getName());
            Party party = partyService.findById(Long.parseLong(id));
            if (party != null && party.getPassword().equals(password)) {
                userService.joinParty(user.getId(), party.getId());
            } else{
                model.addAttribute("error", "Неверный ID или пароль");
                model.addAttribute("user", user);
                model.addAttribute("isUser", WebSecurityConfig.isUser());
                model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
                return "redirect:/user/party/join";
            }
            model.addAttribute("user", user);
        }
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
        return "redirect:/user/party";
    }

//    @PostMapping("/join")
//    public String inviteParty(@RequestParam String name,
//                              @RequestParam String place,
//                              @RequestParam String date,
//                              Principal principal,
//                              Model model) {
//        System.out.println(name + "\n" + place + "\n" + date);
//        if (principal != null) {
//            User user = userService.getByLogin(principal.getName());
//            model.addAttribute("user", user);
//        }
//        model.addAttribute("isUser", WebSecurityConfig.isUser());
//        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
//
////        alcoholService.addAlcohol(new Alcohol(name, Integer.parseInt(strength)));
//        return "user/party";
//    }
}

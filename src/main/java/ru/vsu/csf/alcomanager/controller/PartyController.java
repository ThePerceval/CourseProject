package ru.vsu.csf.alcomanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.csf.alcomanager.model.Party;
import ru.vsu.csf.alcomanager.dto.PartyDTO;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.service.PartyService;
import ru.vsu.csf.alcomanager.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class PartyController {
    private final PartyService partyService;
    private final UserService userService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("/parties")
    public ResponseEntity getAllParties(@RequestParam Long id) {
        User user = userService.find(id);
        List<PartyDTO> parties = new ArrayList<>();
        for (Party party: user.getParties()){
            parties.add(new PartyDTO(party.getId(), party.getName(), party.getPlace(), party.getDate()));
        }
        return new ResponseEntity(parties,  HttpStatus.OK);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/party")
    public ResponseEntity getParty(@RequestParam long id) {
        return new ResponseEntity(partyService.findById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/party")
    public ResponseEntity createParty(@RequestBody Party party, @RequestParam Long id) {
        if (party != null) {
            partyService.addParty(party);
            if (userService.joinParty(id, party.getId())) {
                return new ResponseEntity(party, HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/party/join")
    public ResponseEntity joinParty(@RequestParam Long personId,
                                    @RequestParam Long partyId,
                                    @RequestParam String password
    ) {
        Party party = partyService.findById(partyId);
        if (party != null) {
            if (party.getPassword().equals(password)) {
                if (userService.joinParty(personId, partyId)) {
                    return new ResponseEntity(party, HttpStatus.OK);
                }
                return new ResponseEntity(HttpStatus.CONFLICT);
            }
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

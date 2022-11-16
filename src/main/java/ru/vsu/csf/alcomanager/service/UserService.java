package ru.vsu.csf.alcomanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vsu.csf.alcomanager.model.Party;
import ru.vsu.csf.alcomanager.model.Role;
import ru.vsu.csf.alcomanager.model.User;
import ru.vsu.csf.alcomanager.repository.UserRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AlcoholService alcoholService;
    private final FoodService foodService;
    private final PartyService partyService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

//  CREATE

    public boolean addUser(User user) {
        if (getByLogin(user.getUsername()) != null) {
            return false;
        }
        user.setRole(new Role(1L, "ROLE_USER"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

//  READ

    public User getByLogin(String login) {
        List<User> list = userRepository.findAll();
        for (User u : list) {
            if (u.getUsername().equals(login)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = getByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public Party getPartyById(Long userId, Long id) {
        User user = userRepository.getReferenceById(userId);
        Set<Party> partySet = user.getParties();
        for (Party party : partySet){
            if(party.getId().equals(id)){
                return party;
            }
        }
        return null;
    }

//  UPDATE

    public void likeAlco(Long idPerson, Long idAlco) {
        User p = userRepository.getReferenceById(idPerson);
        p.getAlcohols().add(alcoholService.findByID(idAlco));
        partyService.addAlcohol(idPerson, idAlco);

        userRepository.save(p);
    }

    public void disLikeAlco(Long idPerson, Long idAlco) {
        User p = userRepository.getReferenceById(idPerson);
        p.getAlcohols().remove(alcoholService.findByID(idAlco));
        partyService.deleteAlcohol(idPerson, idAlco);
        userRepository.save(p);
    }

    public void likeFood(Long idPerson, Long idFood) {
        User p = userRepository.getReferenceById(idPerson);
        p.getFoods().add(foodService.findByID(idFood));
        partyService.addFoods(idPerson, idFood);
        userRepository.save(p);
    }

    public void disLikeFood(Long idPerson, Long idFood) {
        User p = userRepository.getReferenceById(idPerson);
        p.getFoods().remove(foodService.findByID(idFood));
        partyService.deleteFoods(idPerson, idFood);
        userRepository.save(p);
    }
    public void joinParty(Long idPerson, Long idParty) {
        User user = userRepository.getReferenceById(idPerson);
        Party party = partyService.findById(idParty);
        user.getParties().add(party);
        partyService.addAllFoods(idPerson, idParty);
        partyService.addAllAlcohols(idPerson, idParty);
        userRepository.save(user);
    }
}

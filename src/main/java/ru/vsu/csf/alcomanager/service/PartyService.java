package ru.vsu.csf.alcomanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.csf.alcomanager.model.*;
import ru.vsu.csf.alcomanager.repository.PartyRepository;
import ru.vsu.csf.alcomanager.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PartyService {
    private final PartyRepository partyRepository;
    private final UserRepository userRepository;
    private final FoodService foodsService;
    private final AlcoholService alcoholService;


    public void addParty(Party party) {
        partyRepository.save(party);
    }

    public Set<Party> getPartiesForPerson(Long id) {
        return userRepository.getReferenceById(id).getParties();
    }

    public Party findById(Long id) {
        List<Party> list = partyRepository.findAll();
        for (Party party : list) {
            if (party.getId().equals(id)) {
                return party;
            }
        }
        return null;
    }

    public void addFoods(Long idPerson, Long idFood) {
        User user = userRepository.getReferenceById(idPerson);
        Set<Party> parties = user.getParties();
        for (Party party : parties) {
            party.getFoods().add(foodsService.findByID(idFood));
            partyRepository.save(party);
        }
    }

    public void addAlcohol(Long idPerson, Long idAlcohol) {
        User user = userRepository.getReferenceById(idPerson);
        Set<Party> parties = user.getParties();
        for (Party party : parties) {
            party.getAlcohols().add(alcoholService.findByID(idAlcohol));
            partyRepository.save(party);
        }
    }

    public void deleteAlcohol(Long idPerson, Long idAlcohol) {
        User user = userRepository.getReferenceById(idPerson);
        Set<Party> parties = user.getParties();
        Alcohol alcohol = alcoholService.findByID(idAlcohol);
        for (Party party : parties) {
            List<Alcohol> newList = new ArrayList<>();
            List<Alcohol> alcohols = partyRepository.getReferenceById(party.getId()).getAlcohols();
            for (Alcohol f : alcohols) {
                if (!f.getId().equals(alcohol.getId())) {
                    newList.add(f);
                }
            }
            party.setAlcohols(newList);
            partyRepository.save(party);
        }
    }

    public void deleteFoods(Long idPerson, Long idFood) {
        User user = userRepository.getReferenceById(idPerson);
        Set<Party> parties = user.getParties();
        Food food = foodsService.findByID(idFood);
        for (Party party : parties) {
            List<Food> newList = new ArrayList<>();
            List<Food> foods = partyRepository.getReferenceById(party.getId()).getFoods();
            for (Food f : foods) {
                if (!f.getId().equals(food.getId())) {
                    newList.add(f);
                }
            }
            party.setFoods(newList);
            partyRepository.save(party);
        }
    }

    public void addAllFoods(Long idPerson, Long idParty) {
        User p = userRepository.getReferenceById(idPerson);
        Party party = partyRepository.getReferenceById(idParty);
        Set<Food> set = p.getFoods();
        List<Food> list = party.getFoods();
        list.addAll(set);
        party.setFoods(list);
        partyRepository.save(party);
    }

    public void addAllAlcohols(Long idPerson, Long idParty) {
        User p = userRepository.getReferenceById(idPerson);
        Party party = partyRepository.getReferenceById(idParty);
        Set<Alcohol> set = p.getAlcohols();
        List<Alcohol> list = party.getAlcohols();
        list.addAll(set);
        party.setAlcohols(list);
        partyRepository.save(party);
    }
}

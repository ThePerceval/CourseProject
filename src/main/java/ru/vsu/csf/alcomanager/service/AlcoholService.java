package ru.vsu.csf.alcomanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.csf.alcomanager.model.Alcohol;
import ru.vsu.csf.alcomanager.repository.AlcoholRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlcoholService {
    private final AlcoholRepository alcoholRepository;

    public List<Alcohol> findAll() {
        return alcoholRepository.findAll();
    }

    public Alcohol findByID(Long id) {
        return alcoholRepository.getReferenceById(id);
    }

    public boolean addAlcohol(Alcohol alcohol) {
        if (getByName(alcohol.getName()) != null) {
            return false;
        }
        alcoholRepository.save(alcohol);
        return true;
    }

    public Alcohol getByName(String name) {
        List<Alcohol> list = alcoholRepository.findAll();
        for (Alcohol alcohol : list) {
            if (alcohol.getName().equals(name)) {
                return alcohol;
            }
        }
        return null;
    }

}

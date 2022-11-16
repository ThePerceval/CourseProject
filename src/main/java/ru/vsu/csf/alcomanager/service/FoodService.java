package ru.vsu.csf.alcomanager.service;

import org.springframework.stereotype.Service;
import ru.vsu.csf.alcomanager.model.Food;
import ru.vsu.csf.alcomanager.repository.FoodRepository;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food findByID(Long id) {
        return foodRepository.getReferenceById(id);
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public boolean addFood(Food food) {
        if (getByName(food.getName()) != null) {
            return false;
        }
        foodRepository.save(food);
        return true;
    }

    public Food getByName(String name) {
        List<Food> list = foodRepository.findAll();
        for (Food food : list) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }
}

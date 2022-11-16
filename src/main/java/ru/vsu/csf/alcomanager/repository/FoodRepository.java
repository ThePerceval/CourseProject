package ru.vsu.csf.alcomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.csf.alcomanager.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
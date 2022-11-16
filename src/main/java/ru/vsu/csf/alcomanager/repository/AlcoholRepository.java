package ru.vsu.csf.alcomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.csf.alcomanager.model.Alcohol;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {
}
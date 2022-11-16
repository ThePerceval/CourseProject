package ru.vsu.csf.alcomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.csf.alcomanager.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
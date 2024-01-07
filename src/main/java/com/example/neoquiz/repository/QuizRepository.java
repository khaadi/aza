package com.example.neoquiz.repository;

import com.example.neoquiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query(value = "SELECT * FROM quiz LIMIT 4", nativeQuery = true)
    List<Quiz> findAllByName();

    Optional<Quiz> findByName(String name);
}

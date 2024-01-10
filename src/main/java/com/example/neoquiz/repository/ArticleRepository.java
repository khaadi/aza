package com.example.neoquiz.repository;

import com.example.neoquiz.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long>, JpaRepository<Article, Long> {
    @Query(value = "SELECT * FROM article WHERE name = :articleName", nativeQuery = true)
    Optional<Article> findByName(String articleName);

    @Query(value = "SELECT * FROM article a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', ?1,'%')) " +
            "AND a.genre LIKE UPPER(CONCAT('%', ?2,'%'))",
            nativeQuery = true)
    List<Article> findAllByNameAndGenre(String name, String genre);
}

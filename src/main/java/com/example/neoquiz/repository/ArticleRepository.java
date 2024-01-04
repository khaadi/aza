package com.example.neoquiz.repository;

import com.example.neoquiz.dto.response.ArticleSearchResponse;
import com.example.neoquiz.entity.Article;
import com.example.neoquiz.enums.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
    Optional<Article> findByName(String name);

    @Query(value = "SELECT * FROM article a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', ?1,'%')) " +
            "AND a.genre LIKE UPPER(CONCAT('%', ?2,'%'))",
            nativeQuery = true)
    List<Article> findAllByNameAndGenre(String name, String genre);
}

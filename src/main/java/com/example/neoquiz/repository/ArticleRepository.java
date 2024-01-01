package com.example.neoquiz.repository;

import com.example.neoquiz.dto.response.ArticleSearchResponse;
import com.example.neoquiz.entity.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
    Optional<Article> findByName(String name);

    @Query(value = "SELECT * FROM articles WHERE name like :'%name%' AND genre :'%genre%'", nativeQuery = true)
    List<ArticleSearchResponse> findAllByName(String name, String genre);
}

package com.example.neoquiz.service;

import com.example.neoquiz.dto.response.ArticleResponse;
import com.example.neoquiz.dto.response.ArticleSearchResponse;
import com.example.neoquiz.entity.Article;
import com.example.neoquiz.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getAllArticles(Pageable pageable) {
        return articleRepository.findAll(pageable).stream().toList();
    }

    public ArticleResponse getArticleByName(String name) {
        Article article = articleRepository.findByName(name).orElseThrow();

        return ArticleResponse.builder()
                .name(article.getName())
                .description(article.getDescription())
                .genre(article.getGenre())
                .build();
    }

    public List<ArticleSearchResponse> searchArticleByNameAndGenre(String name, String genre) {
        return articleRepository.findAllByName(name, genre);
    }


}

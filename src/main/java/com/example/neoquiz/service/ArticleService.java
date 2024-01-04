package com.example.neoquiz.service;

import com.example.neoquiz.dto.response.ArticleResponse;
import com.example.neoquiz.dto.response.ArticleSearchResponse;
import com.example.neoquiz.entity.Article;
import com.example.neoquiz.exception.NotFoundException;
import com.example.neoquiz.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<ArticleSearchResponse> getAllArticles(Pageable pageable) {
        List<Article> articles = articleRepository.findAll(pageable).stream().toList();
        List<ArticleSearchResponse> searchResponses = new ArrayList<>();
        for (Article article: articles) {
            searchResponses.add(ArticleSearchResponse.builder().name(article.getName()).genre(article.getGenre()).build());
        }

        return searchResponses;
    }

    public ArticleResponse getArticleByName(String name) {
        Article article = articleRepository.findByName(name).orElseThrow(() -> new NotFoundException("Article not found!"));

        return ArticleResponse.builder()
                .name(article.getName())
                .description(article.getDescription())
                .genre(article.getGenre())
                .build();
    }

    public List<ArticleSearchResponse> searchArticleByNameAndGenre(String name, String genre) {
        if (genre == null) {
            genre = "";
        }
        return articleRepository.findAllByNameAndGenre(name, genre).stream().map(this::mapToArticleSearchResponse).toList();
    }
    private ArticleSearchResponse mapToArticleSearchResponse(Article article) {
        return ArticleSearchResponse.builder()
                .name(article.getName())
                .genre(article.getGenre())
                .build();
    }


}

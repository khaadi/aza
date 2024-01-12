package com.example.neoquiz.service;

import com.example.neoquiz.dto.response.ArticleResponse;
import com.example.neoquiz.dto.response.ArticleSearchResponse;
import com.example.neoquiz.dto.response.CardResponse;
import com.example.neoquiz.dto.response.MainArticleResponse;
import com.example.neoquiz.entity.Article;
import com.example.neoquiz.exception.NotFoundException;
import com.example.neoquiz.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ImageUploadService uploadService;

    public List<MainArticleResponse> getAllArticles(Pageable pageable) {
        List<Article> articles = articleRepository.findAll(pageable).stream().toList();
        List<MainArticleResponse> mainArticleResponses = new ArrayList<>();
        List<Article> articles1 = articleRepository.findAll();

        for (Article article: articles) {
            mainArticleResponses.add(MainArticleResponse.builder()
                    .name(article.getName())
                    .genre(article.getGenre())
                    .imageUrl(article.getImageUrl())
                    .size(articles1.size())
                    .colorId(article.getColorId())
                    .build());
        }

        return mainArticleResponses;
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

    public CardResponse getCardAndNameForImage(String name) {
        Article article = articleRepository.findByName(name).orElseThrow(() -> new NotFoundException("Article not found!"));

        Random random = new Random();
        Integer token = random.nextInt(1, 9);

        return CardResponse.builder()
                .id(token)
                .name(article.getName())
                .build();
    }

    public String uploadImage(MultipartFile multipartFile, String name) {
        Article article = articleRepository.findByName(name).orElseThrow(() -> new NotFoundException("Article not found!"));

        article.setImageUrl(uploadService.saveImage(multipartFile));
        articleRepository.save(article);
        return "Изображение успешно обновлено";
    }


}

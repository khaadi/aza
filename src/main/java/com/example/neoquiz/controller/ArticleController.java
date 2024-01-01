package com.example.neoquiz.controller;

import com.example.neoquiz.dto.response.ArticleResponse;
import com.example.neoquiz.dto.response.ArticleSearchResponse;
import com.example.neoquiz.entity.Article;
import com.example.neoquiz.service.ArticleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArticleController {
    ArticleService articleService;

    @GetMapping("/getAll")
    public List<Article> getAllArticles(@RequestParam Optional<Integer> pageNum,
                                        @RequestParam Optional<Integer> pageSize) {
        int page = pageNum.filter(p -> p >= 1).map(p -> p - 1).orElse(0);
        int amount = pageSize.orElse(1);
        return articleService.getAllArticles(PageRequest.of(page, amount));
    }

    @GetMapping()
    public List<ArticleSearchResponse> findArticleByNameAndGenre(@RequestParam String name,
                                                                 @RequestParam String genre) {
        return articleService.searchArticleByNameAndGenre(name, genre);
    }
}

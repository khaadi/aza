package com.example.neoquiz.controller;

import com.example.neoquiz.dto.response.ArticleResponse;
import com.example.neoquiz.dto.response.ArticleSearchResponse;
import com.example.neoquiz.enums.Genre;
import com.example.neoquiz.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArticleController {
    ArticleService articleService;

    @GetMapping("/getAll")
    @Operation(summary = "Get all articles", description = "Endpoint for get all articles")
    public List<ArticleSearchResponse> getAllArticles(@RequestParam Optional<Integer> pageNum,
                                        @RequestParam Optional<Integer> pageSize) {
        int page = pageNum.filter(p -> p >= 1).map(p -> p - 1).orElse(0);
        int amount = pageSize.orElse(1);
        return articleService.getAllArticles(PageRequest.of(page, amount));
    }

    @GetMapping("/get")
    @Operation(summary = "Filter and search", description = "Endpoint filter and search for articles")
    public List<ArticleSearchResponse> findArticleByNameAndGenre(@RequestParam String name,
                                                                 @RequestParam String genre) {
        return articleService.searchArticleByNameAndGenre(name, genre);
    }

    @GetMapping("/description")
    @Operation(summary = "Get full description", description = "Endpoint for full article description")
    public ArticleResponse getArticleDescription(@RequestParam String name) {
        return articleService.getArticleByName(name);
    }
}

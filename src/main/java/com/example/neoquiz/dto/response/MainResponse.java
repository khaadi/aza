package com.example.neoquiz.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainResponse {
    List<ArticleSearchResponse> allArticles;
    List<QuizResponse> allQuizzes;
}

package com.example.neoquiz.dto.response;

import com.example.neoquiz.entity.Article;
import com.example.neoquiz.enums.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainArticleResponse {
    String name;
    Genre genre;
    String imageUrl;
    int size;
}

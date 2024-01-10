package com.example.neoquiz.entity;

import com.example.neoquiz.entity.base_entity.BaseEntity;
import com.example.neoquiz.enums.Genre;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Article extends BaseEntity{

    String name;

    @Column(length = 8000)
    String description;

    String imageUrl;

    @Enumerated(EnumType.STRING)
    Genre genre;
}

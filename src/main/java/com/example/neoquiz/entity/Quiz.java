package com.example.neoquiz.entity;

import com.example.neoquiz.entity.base_entity.BaseEntity;
import com.example.neoquiz.enums.Genre;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Quiz extends BaseEntity {

    String name;

    @Enumerated(EnumType.STRING)
    Genre genre;

    String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "quiz")
    List<Question> questions;
}

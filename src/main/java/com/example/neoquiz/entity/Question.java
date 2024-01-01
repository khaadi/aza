package com.example.neoquiz.entity;

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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String name;

    String AnswerTrue;
    String firstAnswerFalse;
    String secondAnswerFalse;
    String thirdAnswerFalse;

    @ManyToOne
    Quiz quiz;
}

package com.example.neoquiz.entity;

import com.example.neoquiz.entity.base_entity.BaseEntity;
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
public class Question extends BaseEntity {

    @Column(unique = true)
    String name;

    String AnswerTrue;
    String firstAnswerFalse;
    String secondAnswerFalse;
    String thirdAnswerFalse;

    @ManyToOne
    Quiz quiz;
}

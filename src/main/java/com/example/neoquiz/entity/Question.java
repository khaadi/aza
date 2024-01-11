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

    @Column(unique = true, length = 8000)
    String name;

    @Column(length = 500)
    String AnswerTrue;
    @Column(length = 500)
    String firstAnswerFalse;
    @Column(length = 500)
    String secondAnswerFalse;
    @Column(length = 500)
    String thirdAnswerFalse;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    Quiz quiz;
}

package com.example.neoquiz.dto.response;

import com.example.neoquiz.entity.Quiz;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionsResponse {
    String name;
    String AnswerTrue;
    String firstAnswerFalse;
    String secondAnswerFalse;
    String thirdAnswerFalse;

}

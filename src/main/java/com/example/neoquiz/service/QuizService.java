package com.example.neoquiz.service;

import com.example.neoquiz.dto.response.QuizFullDescResponse;
import com.example.neoquiz.dto.response.QuizResponse;
import com.example.neoquiz.entity.Quiz;
import com.example.neoquiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public List<QuizResponse> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<QuizResponse> quizResponses = new ArrayList<>();

        for (Quiz quiz : quizzes) {
            quizResponses.add(QuizResponse.builder().name(quiz.getName()).build());
        }
        return quizResponses;
    }

    public QuizFullDescResponse getFullDescriptionById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow();

        return QuizFullDescResponse.builder()
                .name(quiz.getName())
                .description(quiz.getDescription())
                .build();
    }

    private QuizResponse mapQuizToQuizResponse(Quiz quiz) {
        return QuizResponse.builder()
                .name(quiz.getName())
                .build();
    }
}

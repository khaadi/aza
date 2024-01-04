package com.example.neoquiz.controller;

import com.example.neoquiz.dto.response.QuizFullDescResponse;
import com.example.neoquiz.dto.response.QuizResponse;
import com.example.neoquiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quizzes")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @GetMapping("/all")
    public List<QuizResponse> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/getById/{id}")
    public QuizFullDescResponse getFullDescriptionById(@PathVariable Long id) {
        return quizService.getFullDescriptionById(id);
    }
}

package com.example.neoquiz.controller;

import com.example.neoquiz.dto.response.QuestionsResponse;
import com.example.neoquiz.dto.response.QuizFullDescResponse;
import com.example.neoquiz.dto.response.QuizResponse;
import com.example.neoquiz.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/all")
    @Operation(summary = "Get all quizzes", description = "Endpoint for all quizzes")
    public List<QuizResponse> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "Get full description by id", description = "Endpoint for get full quiz description")
    public QuizFullDescResponse getFullDescriptionById(@PathVariable Long id) {
        return quizService.getFullDescriptionById(id);
    }

    @GetMapping("/main")
    @Operation(summary = "Response: 4 quizzes", description = "Endpoint for main")
    public List<QuizResponse> getFourQuizzes() {
        return quizService.getFourQuizzesByName();
    }

    @GetMapping("/questions")
    @Operation(summary = "Get quiz questions use quiz name")
    public List<QuestionsResponse> getQuestions(@RequestParam String name) {
        return quizService.getQuestionsByName(name);
    }

    @PostMapping("/image")
    public String uploadImage(@RequestParam MultipartFile multipartFile, @RequestParam String name) {
        return quizService.uploadImage(multipartFile, name);
    }
}

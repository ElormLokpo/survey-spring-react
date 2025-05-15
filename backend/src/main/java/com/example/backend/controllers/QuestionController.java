package com.example.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.dtos.question.CreateQuestionDto;
import com.example.backend.dtos.response.GetResponseDto;
import com.example.backend.dtos.response.ResponseDto;
import com.example.backend.services.QuestionService;
import java.util.ArrayList;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("{surveyId}")
    public ResponseEntity<ResponseDto> createQuestion(@RequestBody ArrayList<CreateQuestionDto> createQuestionDtos,
            @PathVariable UUID surveyId) {
        return ResponseEntity.ok(this.questionService.createQuestion(createQuestionDtos, surveyId));
    }

    @GetMapping("{surveyId}")
    public ResponseEntity<GetResponseDto> getAllQuestions(
        @PathVariable UUID surveyId, 
        @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
        @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
        @RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir,
        @RequestParam(value = "sortBy", defaultValue = "questionTitle", required = false) String sortBy

        ) {
        return ResponseEntity.ok(this.questionService.getAllQuestions(null, pageSize, pageNo, sortDir, sortBy));
    }

    
    @GetMapping("{questionId}")
    public ResponseEntity<ResponseDto> getQuestion(
        @PathVariable UUID questionId
        ) {
        return ResponseEntity.ok(this.questionService.getQuestion(questionId));
    }
    

}

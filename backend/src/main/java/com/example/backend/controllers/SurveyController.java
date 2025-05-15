package com.example.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dtos.response.GetResponseDto;
import com.example.backend.dtos.response.ResponseDto;
import com.example.backend.dtos.survey.CreateSurveyDto;
import com.example.backend.services.SurveyService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/surveys")
public class SurveyController {

    public SurveyService surveyService;

    public SurveyController(SurveyService _surveyService) {
        this.surveyService = _surveyService;
    }

    @PostMapping("create")
    public ResponseEntity<ResponseDto> createSurvey(@RequestBody CreateSurveyDto createSurveyDto) {
        return ResponseEntity.ok(surveyService.createSurvery(createSurveyDto));
    }

    @GetMapping("all")
    public ResponseEntity<GetResponseDto> getAllSurveys(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "surveyTitle", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir

    ) {
        return ResponseEntity.ok(surveyService.getAllSurveys(pageNo, pageSize, sortBy, sortDir));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getSurveyById(
            @PathVariable UUID id) {
        return ResponseEntity.ok(surveyService.getSurveyById(id));
    }

    @GetMapping("{identifier}")
    public ResponseEntity<ResponseDto> getSurveyByIdentifier(
            @PathVariable String identifier) {
        return ResponseEntity.ok(surveyService.getSurveyByIdentifier(null));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDto> deleteSurveyBy(
            @PathVariable UUID id) {
        return ResponseEntity.ok(surveyService.deleteSurvey(id));
    }

}

package com.example.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.backend.dtos.question.CreateQuestionDto;
import com.example.backend.dtos.question.GetQuestionDto;
import com.example.backend.dtos.response.GetResponseDto;
import com.example.backend.dtos.response.ResponseDto;
import com.example.backend.exceptions.ResourceNotFoundException;
import com.example.backend.mappers.QuestionMapper;
import com.example.backend.models.QuestionModel;
import com.example.backend.models.SurveyModel;
import com.example.backend.repository.QuestionRepository;
import com.example.backend.repository.SurveyRepository;

@Service
public class QuestionService {

    QuestionRepository questionRepository;
    SurveyRepository surveyRepository;

    public QuestionService(QuestionRepository questionRepository, SurveyRepository survRepository) {
        this.questionRepository = questionRepository;
        this.surveyRepository = survRepository;
    }

    public ResponseDto createQuestion(ArrayList<CreateQuestionDto> createQuestionsDto, UUID surveyId) {
        SurveyModel surveyModel = this.surveyRepository.findById(surveyId)
                .orElseThrow(() -> new ResourceNotFoundException("Survey with id: " + surveyId + " not found."));

        List<QuestionModel> questionProcessed = createQuestionsDto.stream().map(question -> {
            question.setSurvey(surveyModel);
            return QuestionMapper.INSTANCE.questionDtoToModel(question);
        }).collect(Collectors.toList());

        return ResponseDto.builder()
                .success(true)
                .message("Question added")
                .data(this.questionRepository.saveAll(questionProcessed))
                .build();

    }

    public GetResponseDto getAllQuestions(UUID surveyId, int pageSize, int pageNo, String sortDir, String sortBy) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<QuestionModel> questionPage = questionRepository.findQuestionsBySurvey(surveyId);

        List<QuestionModel> questionContent = questionPage.getContent();
        List<GetQuestionDto> questionsArr = questionContent.stream().map(question->QuestionMapper.INSTANCE.questionModelToDto(question)).collect(Collectors.toList());
        
        return GetResponseDto.builder()
        .success(true)
        .message("Questions query successful")
        .data(questionsArr)
        .pageNumber(pageNo)
        .pageSize(pageSize)
        .totalPages(questionPage.getTotalPages())
        .build();

    }

    public ResponseDto getQuestion(UUID questionId){
        return ResponseDto.builder()
        .success(true)
        .message("Question request successful")
        .data(this.questionRepository.findById(questionId).orElseThrow(()-> new ResourceNotFoundException("Question with id: "+questionId+" not found.")))
        .build();
    }

    
}

package com.example.backend.services;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.backend.dao.SurveyDao;
import com.example.backend.dtos.response.GetResponseDto;
import com.example.backend.dtos.response.ResponseDto;
import com.example.backend.dtos.survey.CreateSurveyDto;
import com.example.backend.dtos.survey.GetSurveyDto;
import com.example.backend.exceptions.ResourceNotFoundException;
import com.example.backend.mappers.SurveyMapper;
import com.example.backend.models.SurveyModel;
import com.example.backend.repository.SurveyRepository;

@Service
public class SurveyService implements SurveyDao {
        SurveyRepository surveyRepository;

        public SurveyService(SurveyRepository _surveyRepository) {
                this.surveyRepository = _surveyRepository;
        }

        public ResponseDto createSurvery(CreateSurveyDto createSurveyDto) {
                return ResponseDto.builder()
                                .success(true)
                                .message("Survey created successfully")
                                .data(surveyRepository.save(SurveyMapper.INSTANCE.surveyDtoToModel(createSurveyDto)))
                                .build();
        }

        public GetResponseDto getAllSurveys(int pageNo, int pageSize, String sortBy, String sortDir) {
                // there is going to be a filter by user
                Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                                : Sort.by(sortBy).descending();

                Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
                Page<SurveyModel> surveyPage = surveyRepository.findAll(pageable);

                Collection<SurveyModel> surveyContent = surveyPage.getContent();
                Collection<GetSurveyDto> surveyResults = surveyContent.stream()
                                .map(surv -> SurveyMapper.INSTANCE.surveyModelToDto(surv)).collect(Collectors.toList());

                return GetResponseDto.builder()
                                .success(true)
                                .message("Survey query successful")
                                .data(surveyResults)
                                .pageSize(pageSize)
                                .pageNumber(surveyPage.getNumber())
                                .totalPages(surveyPage.getTotalPages())
                                .build();

        }

        public ResponseDto getSurveyByIdentifier(String identifier) {

                return ResponseDto.builder()
                                .success(true)
                                .message("Survey query successful")
                                .data(SurveyMapper.INSTANCE
                                                .surveyModelToDto(surveyRepository.findSurveyByIdentifier(identifier)
                                                                .orElseThrow(
                                                                                () -> new ResourceNotFoundException(
                                                                                                "Survey with identifier "
                                                                                                                + identifier
                                                                                                                + " does not exist"))))
                                .build();
        }

        public ResponseDto getSurveyById(UUID id) {
                return ResponseDto.builder()
                                .success(true)
                                .message("Survey query successful")
                                .data(SurveyMapper.INSTANCE
                                                .surveyModelToDto(surveyRepository.findById(id).orElseThrow(
                                                                () -> new ResourceNotFoundException(
                                                                                "Survey with ID: " + id
                                                                                                + " does not exist"))))
                                .build();
        }

        public ResponseDto deleteSurvey(UUID id) {
                var userExists = surveyRepository.existsById(id);

                surveyRepository.deleteById(id);
                return ResponseDto.builder()
                                .success(userExists ? true : false)
                                .message(userExists ? "User deleted successfully" : "User not found")
                                .data(userExists)
                                .build();
        }

}

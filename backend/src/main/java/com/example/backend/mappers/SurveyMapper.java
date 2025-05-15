package com.example.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.backend.dtos.survey.CreateSurveyDto;
import com.example.backend.dtos.survey.GetSurveyDto;
import com.example.backend.models.SurveyModel;

@Mapper
public interface SurveyMapper {
    SurveyMapper INSTANCE = Mappers.getMapper(SurveyMapper.class);

    public SurveyModel surveyDtoToModel(CreateSurveyDto createSurveyDto);
    public GetSurveyDto surveyModelToDto(SurveyModel surveyModel);
}

package com.example.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.backend.dtos.question.CreateQuestionDto;
import com.example.backend.dtos.question.GetQuestionDto;
import com.example.backend.models.QuestionModel;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    public QuestionModel questionDtoToModel(CreateQuestionDto createQuestionDto);

    public GetQuestionDto questionModelToDto(QuestionModel questionModel);
}

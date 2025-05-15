package com.example.backend.dtos.question;

import java.util.ArrayList;

import com.example.backend.models.SurveyModel;
import com.example.backend.models.enums.QuestionTypeEnum;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateQuestionDto {
    public QuestionTypeEnum questionType;

    public String questionTitle;
    public String questionDescription;

    public ArrayList<String> questionOptions;

    public Integer highestNumberRange;
    public Integer numberStep;
    public SurveyModel survey;
}

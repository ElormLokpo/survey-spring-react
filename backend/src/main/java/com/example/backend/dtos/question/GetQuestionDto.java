package com.example.backend.dtos.question;

import java.util.ArrayList;

import com.example.backend.models.enums.QuestionTypeEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetQuestionDto {
    public QuestionTypeEnum questionType;

    public String questionTitle;
    public String questionDescription;

    public ArrayList<String> questionOptions;

    public Integer highestNumberRange;
    public Integer numberStep;
}

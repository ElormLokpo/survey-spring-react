package com.example.backend.dtos.survey;

import java.util.ArrayList;
import java.util.UUID;
import com.example.backend.models.QuestionModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetSurveyDto {
    public UUID id;
    public String surveyIdentifier;
    public String surveyTitle;
    public String surveyDescription;
    public ArrayList<QuestionModel> surveyQuestions;

}

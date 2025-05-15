package com.example.backend.dtos.survey;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateSurveyDto {
    public String surveyIdentifier;
    public String surveyTitle;
    public String surveyDescription;
}

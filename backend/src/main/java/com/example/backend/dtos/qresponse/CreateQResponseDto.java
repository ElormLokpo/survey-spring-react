package com.example.backend.dtos.qresponse;


import java.util.ArrayList;
import com.example.backend.models.AnswerModel;
import com.example.backend.models.SurveyModel;

public class CreateQResponseDto {
    public String fullname;
    public String email;

    public ArrayList<AnswerModel> userAnswer;
    public SurveyModel survey;
}

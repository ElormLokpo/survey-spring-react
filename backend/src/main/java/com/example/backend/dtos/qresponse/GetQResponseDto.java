package com.example.backend.dtos.qresponse;

import java.util.ArrayList;
import java.util.UUID;

import com.example.backend.models.AnswerModel;

public class GetQResponseDto {
    public UUID id;
    public String fullname;
    public String email;
    public ArrayList<AnswerModel> userAnswer;

}

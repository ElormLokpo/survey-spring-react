package com.example.backend.models;

import java.util.ArrayList;
import java.util.UUID;

import com.example.backend.models.enums.QuestionTypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "questions")
public class QuestionModel {
    @Id
    @GeneratedValue
    public UUID id;

    public QuestionTypeEnum questionType;

    public String questionTitle;
    public String questionDescription;

    public ArrayList<String> questionOptions;

    public Integer highestNumberRange;
    public Integer numberStep;

    @ManyToOne
    @JoinColumn(name = "survey")
    public SurveyModel survey;
}

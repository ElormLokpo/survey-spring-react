package com.example.backend.models;

import java.util.ArrayList;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "survey")
public class SurveyModel {
    @Id
    @GeneratedValue
    public UUID id;

    public String surveyIdentifier;
    public String surveyTitle;
    public String surveyDescription;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    public ArrayList<QuestionModel> surveyQuestions = new ArrayList<>();

    @Builder.Default
    public Boolean IsAnonymous = false;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY, orphanRemoval = true)
    public ArrayList<QResponseModel> surveyResponses = new ArrayList<>();
}

package com.example.backend.models;

import java.util.ArrayList;
import java.util.UUID;
import jakarta.persistence.Embedded;
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
@Entity(name = "responses")
public class QResponseModel {
    @Id
    @GeneratedValue
    public UUID id;

    public String fullname;
    public String email;

    // where UUID is the question id
    @Embedded
    @Builder.Default
    public ArrayList<AnswerModel> userAnswers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "survey")
    public SurveyModel survey;
}

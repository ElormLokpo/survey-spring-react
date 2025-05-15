package com.example.backend.models;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class AnswerModel {
    public UUID questionId;
    public String answer;
}

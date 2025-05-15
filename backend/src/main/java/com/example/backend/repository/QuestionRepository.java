package com.example.backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.backend.models.QuestionModel;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, UUID> {
    @Query("SELECT q from questions q WHERE q.suvery.id = :surveyId")
    public Page<QuestionModel> findQuestionsBySurvey(UUID surveyId);
}

package com.example.backend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.models.SurveyModel;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyModel, UUID> {

    @Query("SELECT s from survey s WHERE s.surveyIdentifier = :identifier")
    public Optional<SurveyModel> findSurveyByIdentifier(String identifier);
}

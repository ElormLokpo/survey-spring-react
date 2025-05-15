package com.example.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.models.QResponseModel;

@Repository
public interface QResponseRepository extends JpaRepository<QResponseModel, UUID> {

}

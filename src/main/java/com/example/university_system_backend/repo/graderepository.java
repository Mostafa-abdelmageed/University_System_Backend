package com.example.university_system_backend.repo;

import com.example.university_system_backend.model.grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface graderepository extends JpaRepository<grade, Integer> {
}
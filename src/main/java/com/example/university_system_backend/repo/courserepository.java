package com.example.university_system_backend.repo;

import com.example.university_system_backend.model.course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courserepository extends JpaRepository<course, Integer> {
}
package com.example.university_system_backend.repo;

import com.example.university_system_backend.model.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentrepository extends JpaRepository<student, Integer> {
}

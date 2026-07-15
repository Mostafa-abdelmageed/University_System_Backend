package com.example.university_system_backend.repo;

import com.example.university_system_backend.model.faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface facultyrepository extends JpaRepository<faculty, Integer> {
}

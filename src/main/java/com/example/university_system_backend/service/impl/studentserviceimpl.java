package com.example.university_system_backend.service.impl;

import com.example.university_system_backend.model.student;
import com.example.university_system_backend.repo.studentrepository;
import com.example.university_system_backend.service.studentservice;
import com.example.university_system_backend.web.dto.Studentdto;
import com.example.university_system_backend.web.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentserviceimpl implements studentservice {

    private final studentrepository repository;
    private final StudentMapper mapper;

    public studentserviceimpl(studentrepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Studentdto createStudent(Studentdto dto) {
        validateStudent(dto);
        checkEmailUnique(dto.getEmail(), null);

        student entity = mapper.toEntity(dto);
        student saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public List<Studentdto> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Studentdto getStudentById(Integer id) {
        student entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public Studentdto updateStudent(Integer id, Studentdto dto) {
        student entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        validateStudent(dto);
        checkEmailUnique(dto.getEmail(), id);

        entity.setFirst_name(dto.getFirst_name());
        entity.setLast_name(dto.getLast_name());
        entity.setEmail(dto.getEmail());
        entity.setCurrentlevel(dto.getCurrentlevel());
        entity.setFaculty_id(dto.getFaculty_id());

        student updated = repository.save(entity);
        return mapper.toDto(updated);
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    // ---- validation helpers ----

    private void validateStudent(Studentdto dto) {
        if (dto.getFirst_name() == null || dto.getFirst_name().isBlank()) {
            throw new RuntimeException("First name is required");
        }
        if (dto.getLast_name() == null || dto.getLast_name().isBlank()) {
            throw new RuntimeException("Last name is required");
        }
        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new RuntimeException("Email is required");
        }
        if (dto.getCurrentlevel() == null || dto.getCurrentlevel() < 1 || dto.getCurrentlevel() > 5) {
            throw new RuntimeException("Level must be between 1 and 5");
        }
    }

    private void checkEmailUnique(String email, Integer currentStudentId) {
        boolean emailTaken = repository.findAll().stream()
                .anyMatch(s -> s.getEmail().equalsIgnoreCase(email)
                        && (currentStudentId == null || !s.getStudent_id().equals(currentStudentId)));

        if (emailTaken) {
            throw new RuntimeException("Email already in use: " + email);
        }
    }
}
package com.example.university_system_backend.web.controller;

import com.example.university_system_backend.service.studentservice;
import com.example.university_system_backend.web.dto.Studentdto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final studentservice studentService;

    public StudentController(studentservice studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Studentdto> createStudent(@RequestBody Studentdto dto) {
        Studentdto created = studentService.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Studentdto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studentdto> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studentdto> updateStudent(@PathVariable Integer id, @RequestBody Studentdto dto) {
        return ResponseEntity.ok(studentService.updateStudent(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}

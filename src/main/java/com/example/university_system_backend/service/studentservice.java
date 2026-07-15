package com.example.university_system_backend.service;

import com.example.university_system_backend.web.dto.Studentdto;
import java.util.List;

public interface studentservice {

    Studentdto createStudent(Studentdto dto);

    List<Studentdto> getAllStudents();

    Studentdto getStudentById(Integer id);

    Studentdto updateStudent(Integer id, Studentdto dto);

    void deleteStudent(Integer id);
}

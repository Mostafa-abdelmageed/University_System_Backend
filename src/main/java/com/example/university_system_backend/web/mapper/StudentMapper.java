package com.example.university_system_backend.web.mapper;

import com.example.university_system_backend.model.student;
import com.example.university_system_backend.web.dto.Studentdto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Studentdto toDto(student entity);

    student toEntity(Studentdto dto);
}
package com.example.university_system_backend.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studentdto {

    private Integer student_id;
    private String first_name;
    private String last_name;
    private String email;
    private Integer currentlevel;
    private Integer faculty_id;
}
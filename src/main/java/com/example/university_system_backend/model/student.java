
        package com.example.university_system_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class student {

    @Id
    private Integer student_id;
    private String first_name;
    private String last_name;
    private String email;
    private Integer currentlevel;
    private Integer faculty_id;
}
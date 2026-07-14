package com.example.university_system_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class grade {

    @Id
    private Integer grade_id;
    private Integer student_id;
    private Integer course_id;
    private Integer gradevalue;
}
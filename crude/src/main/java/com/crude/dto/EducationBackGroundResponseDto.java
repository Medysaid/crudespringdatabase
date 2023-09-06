package com.crude.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationBackGroundResponseDto {
    private Long educationId;
    private String institutionName; // Name of the educational institution
    private String degree;          // Degree obtained (e.g., Bachelor's, Master's)
    private String major;           // Field of study or major
    private LocalDate startDate;         // Start date of education
    private LocalDate endDate;           // End date of education or expected graduation date
    private String location;        // Location of the institution (e.g., city, country)
    private  Long id;
}

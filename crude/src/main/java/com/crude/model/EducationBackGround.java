package com.crude.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Table
@Entity
public class EducationBackGround {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;
    private String institutionName; // Name of the educational institution
    private String educationLevel;          // Degree obtained (e.g., Bachelor's, Master's)
    private String major;           // Field of study or major
    private LocalDate startDate;         // Start date of education
    private LocalDate endDate;           // End date of education or expected graduation date
    private String location;        // Location of the institution (e.g., city, country)
    @ManyToOne
    @JoinColumn(name = "id")
    private StaffPersonalDetails staffPersonalDetails;
}

package com.crude.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Table
@Entity
public class StaffPersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private LocalDate dob;
    private String gender;
    private String phoneNumber;
    private String address;
    @OneToMany(mappedBy = "staffPersonalDetails")
    private List<EducationBackGround> educationBackGround;
}

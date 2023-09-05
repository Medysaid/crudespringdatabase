package com.crude.dto;

import com.crude.model.EducationBackGround;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class StaffPersonalDetailsRequestDto {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private LocalDate dob;
    private String gender;
    private String phoneNumber;
    private String address;
}

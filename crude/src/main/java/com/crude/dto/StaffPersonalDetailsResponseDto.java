package com.crude.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StaffPersonalDetailsResponseDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private LocalDate dob;
    private String gender;
    private String phoneNumber;
    private String address;
}

package com.crude.services;

import com.crude.dto.StaffPersonalDetailsRequestDto;
import com.crude.dto.StaffPersonalDetailsResponseDto;
import com.crude.model.StaffPersonalDetails;
import com.crude.repository.StaffPersonalDetailsRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class StaffPersonalDetailsService {
    private final StaffPersonalDetailsRepository staffPersonalDetailsRepository;
    private final ModelMapper modelMapper;

    // Create method
    public ResponseEntity<Boolean> create(StaffPersonalDetailsRequestDto staffPersonalDetailsRequestDto) {
        // Map the DTO to the entity
        StaffPersonalDetails staffPersonalDetails = modelMapper.map(staffPersonalDetailsRequestDto, StaffPersonalDetails.class);

        // Save the entity to the repository
        staffPersonalDetailsRepository.save(staffPersonalDetails);

        // Return a successful response
        return ResponseEntity.ok(Boolean.TRUE);
    }

    // Update method
    public ResponseEntity<Boolean> update(Long id, StaffPersonalDetailsRequestDto staffPersonalDetailsRequestDto) {
        // Check if the staff personal details record exists in the repository
        Optional<StaffPersonalDetails> getById = staffPersonalDetailsRepository.findById(id);
        if (!getById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        // Map the DTO to the entity and set the ID
        StaffPersonalDetails staffPersonalDetails = modelMapper.map(staffPersonalDetailsRequestDto, StaffPersonalDetails.class);
        staffPersonalDetails.setId(id);

        // Save the updated entity to the repository
        staffPersonalDetailsRepository.save(staffPersonalDetails);

        // Return a successful response
        return ResponseEntity.ok(Boolean.TRUE);
    }

    // Get by ID method
    public ResponseEntity<StaffPersonalDetailsResponseDto> getById(Long id) {
        // Check if the staff personal details record exists in the repository
        Optional<StaffPersonalDetails> getById = staffPersonalDetailsRepository.findById(id);
        if (!getById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        // Map the entity to a DTO
        StaffPersonalDetailsResponseDto staffPersonalDetails = modelMapper.map(getById.get(), StaffPersonalDetailsResponseDto.class);

        // Return the DTO in the response
        return ResponseEntity.ok(staffPersonalDetails);
    }

    // Get all method
    public ResponseEntity<List<StaffPersonalDetailsResponseDto>> getAll() {
        // Retrieve all staff personal details records from the repository
        List<StaffPersonalDetails> staffPersonalDetails = staffPersonalDetailsRepository.findAll();
        List<StaffPersonalDetailsResponseDto> list = new ArrayList<>();
        StaffPersonalDetailsResponseDto staffPersonalDetailsResponseDto = null;

        // Map each entity to a DTO
        for (StaffPersonalDetails staffPersonalDetails1 : staffPersonalDetails) {
            staffPersonalDetailsResponseDto = modelMapper.map(staffPersonalDetails1, StaffPersonalDetailsResponseDto.class);
            list.add(staffPersonalDetailsResponseDto);
        }

        // Return the list of DTOs in the response
        return ResponseEntity.ok(list);
    }
}

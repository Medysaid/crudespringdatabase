package com.crude.services;

import com.crude.dto.EducationBackGroundRequestDto;
import com.crude.dto.EducationBackGroundResponseDto;
import com.crude.model.EducationBackGround;
import com.crude.model.StaffPersonalDetails;
import com.crude.repository.EducationBackGroundRepository;
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
public class EducationBackGroundService {
    private final EducationBackGroundRepository educationRepository;
    private final ModelMapper modelMapper;

    // Create method
    public ResponseEntity<Boolean> create(EducationBackGroundRequestDto edurqt) {
        // Map the DTO to the entity
        EducationBackGround educationBackGround = modelMapper.map(edurqt, EducationBackGround.class);

        // Create a new StaffPersonalDetails instance and associate it with the educationBackGround
        StaffPersonalDetails staffPersonalDetails = new StaffPersonalDetails();
        staffPersonalDetails.setId(educationBackGround.getEducationId());
        educationBackGround.setStaffPersonalDetails(staffPersonalDetails);

        // Save the entity to the repository
        educationRepository.save(educationBackGround);

        // Return a successful response
        return ResponseEntity.ok(Boolean.TRUE);
    }

    // Update method
    public ResponseEntity<Boolean> update(Long id, EducationBackGroundRequestDto edurqt) {
        // Check if the education record exists in the repository
        Optional<EducationBackGround> getById = educationRepository.findById(id);
        if (!getById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        // Map the DTO to the entity and set the ID
        EducationBackGround educationBackGround = modelMapper.map(edurqt, EducationBackGround.class);
        educationBackGround.setEducationId(id);

        // Create a new StaffPersonalDetails instance and associate it with the educationBackGround
        StaffPersonalDetails staffPersonalDetails = new StaffPersonalDetails();
        staffPersonalDetails.setId(educationBackGround.getEducationId());
        educationBackGround.setStaffPersonalDetails(staffPersonalDetails);

        // Save the updated entity to the repository
        educationRepository.save(educationBackGround);

        // Return a successful response
        return ResponseEntity.ok(Boolean.TRUE);
    }

    // Get by ID method
    public ResponseEntity<EducationBackGroundResponseDto> getById(Long id) {
        // Check if the education record exists in the repository
        Optional<EducationBackGround> getById = educationRepository.findById(id);
        if (!getById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        // Map the entity to a DTO and set the ID
        EducationBackGroundResponseDto educationBackGroundResponseDto = modelMapper.map(getById.get(), EducationBackGroundResponseDto.class);
        educationBackGroundResponseDto.setId(getById.get().getStaffPersonalDetails().getId());

        // Return the DTO in the response
        return ResponseEntity.ok(educationBackGroundResponseDto);
    }

    // Get all method
    public ResponseEntity<List<EducationBackGroundResponseDto>> getAll() {
        // Retrieve all education records from the repository
        List<EducationBackGround> educationBackGrounds = educationRepository.findAll();
        List<EducationBackGroundResponseDto> list = new ArrayList<>();
        EducationBackGroundResponseDto educationBackGroundResponseDto = null;

        // Map each entity to a DTO and set the ID
        for (EducationBackGround educationBackGround : educationBackGrounds) {
            educationBackGroundResponseDto = modelMapper.map(educationBackGround, EducationBackGroundResponseDto.class);
            educationBackGroundResponseDto.setId(educationBackGround.getStaffPersonalDetails().getId());
            list.add(educationBackGroundResponseDto);
        }

        // Return the list of DTOs in the response
        return ResponseEntity.ok(list);
    }
}

package com.crude.services;

import com.crude.dto.StaffPersonalDetailsRequestDto;
import com.crude.dto.StaffPersonalDetailsResponseDto;
import com.crude.model.EducationBackGround;
import com.crude.model.StaffPersonalDetails;
import com.crude.repository.StaffPersonalDetailsRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class StaffPersonalDetailsService {
    private final StaffPersonalDetailsRepository staffPersonalDetailsRepository;
    private final ModelMapper modelMapper;

    public ResponseEntity<Boolean> create(StaffPersonalDetailsRequestDto staffPersonalDetailsRequestDto){
        StaffPersonalDetails staffPersonalDetails = modelMapper.map(staffPersonalDetailsRequestDto,StaffPersonalDetails.class);
        staffPersonalDetailsRepository.save(staffPersonalDetails);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    public ResponseEntity<Boolean> Update(Long id,StaffPersonalDetailsRequestDto staffPersonalDetailsRequestDto){
        Optional<StaffPersonalDetails> getById = staffPersonalDetailsRepository.findById(id);
        if(!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        StaffPersonalDetails staffPersonalDetails = modelMapper.map(staffPersonalDetailsRequestDto,StaffPersonalDetails.class);
        staffPersonalDetails.setId(id);
        staffPersonalDetailsRepository.save(staffPersonalDetails);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    public ResponseEntity<StaffPersonalDetailsResponseDto> getById(Long id){
        Optional<StaffPersonalDetails> getById = staffPersonalDetailsRepository.findById(id);
        if(!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        StaffPersonalDetailsResponseDto staffPersonalDetails = modelMapper.map(getById.get(),StaffPersonalDetailsResponseDto.class);

//        staffPersonalDetailsRepository.save(staffPersonalDetails);
        return ResponseEntity.ok(staffPersonalDetails);
    }
    public ResponseEntity<List<StaffPersonalDetailsResponseDto>> getAll(){
        List<StaffPersonalDetailsResponseDto> list = new ArrayList<>();
      List<StaffPersonalDetails> staffPersonalDetails = staffPersonalDetailsRepository.findAll();
      StaffPersonalDetailsResponseDto staffPersonalDetailsResponseDto = null;
      for (StaffPersonalDetails staffPersonalDetails1 :staffPersonalDetails){
          staffPersonalDetailsResponseDto=modelMapper.map(staffPersonalDetails1, StaffPersonalDetailsResponseDto.class);
          list.add(staffPersonalDetailsResponseDto);
      }
//        staffPersonalDetailsRepository.save(staffPersonalDetails);
        return ResponseEntity.ok(list);
    }
//    StaffPersonalDetailsResponseDto
}

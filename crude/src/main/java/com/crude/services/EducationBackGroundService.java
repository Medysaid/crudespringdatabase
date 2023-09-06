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
public class EducationBackGroundService  {
    private final EducationBackGroundRepository educationRepository;
    private final ModelMapper modelMapper;

    public ResponseEntity<Boolean> create(EducationBackGroundRequestDto edurqt){
        EducationBackGround educationBackGround = modelMapper.map(edurqt,EducationBackGround.class);
        StaffPersonalDetails staffPersonalDetails = new StaffPersonalDetails();
        staffPersonalDetails.setId(educationBackGround.getEducationId());
        educationBackGround.setStaffPersonalDetails(staffPersonalDetails);
        educationRepository.save(educationBackGround);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    public ResponseEntity<Boolean> Update(Long id,EducationBackGroundRequestDto edurqt){
        Optional<EducationBackGround> getById = educationRepository.findById(id);
        if(!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        EducationBackGround educationBackGround = modelMapper.map(edurqt,EducationBackGround.class);
        educationBackGround.setEducationId(id);
        StaffPersonalDetails staffPersonalDetails = new StaffPersonalDetails();
        staffPersonalDetails.setId(educationBackGround.getEducationId());
        educationBackGround.setStaffPersonalDetails(staffPersonalDetails);
        educationRepository.save(educationBackGround);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    public ResponseEntity<EducationBackGroundResponseDto> getById(Long id){
        Optional<EducationBackGround> getById = educationRepository.findById(id);
        if(!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        EducationBackGroundResponseDto educationBackGroundResponseDto = modelMapper.map(getById.get(),EducationBackGroundResponseDto.class);
        educationBackGroundResponseDto.setId(getById.get().getStaffPersonalDetails().getId());
//        educationRepository.save(staffPersonalDetails);
        return ResponseEntity.ok(educationBackGroundResponseDto);
    }
    public ResponseEntity<List<EducationBackGroundResponseDto>> getAll(){
        List<EducationBackGroundResponseDto> list = new ArrayList<>();
        List<EducationBackGround> educationBackGrounds = educationRepository.findAll();
        EducationBackGroundResponseDto educationBackGroundResponseDto = null;
        for (EducationBackGround educationBackGround :educationBackGrounds){
            educationBackGroundResponseDto=modelMapper.map(educationBackGround, EducationBackGroundResponseDto.class);
            educationBackGroundResponseDto.setId(educationBackGround.getStaffPersonalDetails().getId());
            list.add(educationBackGroundResponseDto);
        }
//        educationRepository.save(staffPersonalDetails);
        return ResponseEntity.ok(list);
    }
}

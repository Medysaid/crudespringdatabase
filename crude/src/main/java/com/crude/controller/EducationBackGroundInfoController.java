package com.crude.controller;


import com.crude.dto.EducationBackGroundRequestDto;

import com.crude.services.EducationBackGroundService;
import lombok.Data;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("education-back-ground")
@Data
public class EducationBackGroundInfoController {
    private final EducationBackGroundService educationBackGroundService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity getAll(){

        return educationBackGroundService.getAll();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity getAllById(@PathVariable("id") Long id){

        return educationBackGroundService.getById(id);
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody EducationBackGroundRequestDto educationBackGroundRequestDto){

        return educationBackGroundService.create(educationBackGroundRequestDto);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity updates(@PathVariable("id") Long id,@RequestBody EducationBackGroundRequestDto educationBackGroundRequestDto){

        return educationBackGroundService.Update(id,educationBackGroundRequestDto);
    }

}

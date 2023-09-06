package com.crude.controller;

import com.crude.dto.StaffPersonalDetailsRequestDto;
import com.crude.services.StaffPersonalDetailsService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("staff-personal-details")
@Data
public class StaffPersonalDetailsController {
    private final StaffPersonalDetailsService staffPersonalDetailsService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity getAll(){

        return staffPersonalDetailsService.getAll();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity getAllById(@PathVariable("id") Long id){

        return staffPersonalDetailsService.getById(id);
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody StaffPersonalDetailsRequestDto staffPersonalDetailsRequestDto){

        return staffPersonalDetailsService.create(staffPersonalDetailsRequestDto);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity updates(@PathVariable("id") Long id,@RequestBody StaffPersonalDetailsRequestDto staffPersonalDetailsRequestDto){

        return staffPersonalDetailsService.Update(id,staffPersonalDetailsRequestDto);
    }
}

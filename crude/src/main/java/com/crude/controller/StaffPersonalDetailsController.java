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

    // GET endpoint to retrieve all staff personal details
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return staffPersonalDetailsService.getAll();
    }

    // GET endpoint to retrieve staff personal details by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllById(@PathVariable("id") Long id) {
        return staffPersonalDetailsService.getById(id);
    }

    // POST endpoint to create a new staff personal details record
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody StaffPersonalDetailsRequestDto staffPersonalDetailsRequestDto) {
        return staffPersonalDetailsService.create(staffPersonalDetailsRequestDto);
    }

    // PUT endpoint to update an existing staff personal details record
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updates(@PathVariable("id") Long id, @RequestBody StaffPersonalDetailsRequestDto staffPersonalDetailsRequestDto) {
        return staffPersonalDetailsService.update(id, staffPersonalDetailsRequestDto);
    }
}

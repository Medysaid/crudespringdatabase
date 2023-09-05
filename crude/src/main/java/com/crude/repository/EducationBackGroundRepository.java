package com.crude.repository;

import com.crude.model.EducationBackGround;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EducationBackGroundRepository extends JpaRepository<EducationBackGround,Long> {

}

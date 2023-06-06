package com.example.securityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.InstructorDetailsResponse;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {


    @Query("select new peaksoft.dto.response.InstructorResponse(i.id,i.first_name,i.last_name,i.phone_number,i.specialization)from Instructor i ")
    List<InstructorResponse> getAllInstructor();


    @Query("SELECT new peaksoft.dto.response.InstructorDetailsResponse(i.id, i.first_name, i.last_name, i.specialization, g.group_name, COUNT(s)) " +
            "FROM Instructor i " +
            " JOIN i.courses c " +
            " JOIN c.groups g " +
            " JOIN g.students s " +
            "where i.id = ?1  GROUP BY i.id, i.first_name, i.last_name, i.specialization, g.group_name" )
    List<InstructorDetailsResponse> getAllInstructorsDetails(Long id);


    @Query("select new peaksoft.dto.response.InstructorResponse(i.id,i.first_name,i.last_name,i.phone_number,i.specialization)from Instructor i where i.id=:id")
   Optional<InstructorResponse> getInstructorId(Long id);
}
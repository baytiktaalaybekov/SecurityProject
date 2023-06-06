package com.example.securityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entity.Student;
import peaksoft.enums.StudyFormat;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select new peaksoft.dto.response.StudentResponse(s.id,s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat,s.isBlocked) from Student s")
    List<StudentResponse> getAllStudent();

    @Query("select new peaksoft.dto.response.StudentResponse(s.id,s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat,s.isBlocked) from Student s where s.id=:id")
    Optional<StudentResponse> getStudentById(Long id);


    List<StudentResponse>findByStudyFormat(StudyFormat studyFormat);


}
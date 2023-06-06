package com.example.securityproject.service;

import peaksoft.dto.request.AssignCourseRequest;
import peaksoft.dto.request.AssignRequest;
import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.response.InstructorDetailsResponse;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.dto.response.SimpleResponse;

import java.util.List;

public interface InstructorSe {

    SimpleResponse saveInstructor(InstructorRequest instructorRequest);

    List<InstructorResponse> getAllInstructor();

    List<InstructorDetailsResponse> getAllInfoInstructor(Long id);

    InstructorResponse getInstructorId(Long id);

    SimpleResponse update(Long id,InstructorRequest instructorRequest);

    SimpleResponse deleteById(Long id);

    SimpleResponse assignInstructorToCompany(AssignRequest assignRequest);

    SimpleResponse assignInstructorToCourse(AssignCourseRequest assignCourseRequest);
}

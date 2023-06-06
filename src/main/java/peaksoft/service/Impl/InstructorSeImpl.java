package com.example.securityproject.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.AssignCourseRequest;
import peaksoft.dto.request.AssignRequest;
import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.response.InstructorDetailsResponse;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repository.CompanyRepository;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.InstructorRepository;
import peaksoft.service.InstructorSe;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorSeImpl implements InstructorSe {

    private final InstructorRepository instructorRepository;
    private final CompanyRepository companyRepository;
    private final CourseRepository courseRepository;

    @Override
    public SimpleResponse saveInstructor(InstructorRequest instructorRequest) {
        Instructor instructor = new Instructor();
        instructor.setFirst_name(instructorRequest.getFirst_name());
        instructor.setLast_name(instructorRequest.getLast_name());
        instructor.setPhone_number(instructorRequest.getPhone_number());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructorRepository.save(instructor);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Save Instructor")
                .build();
    }

    @Override
    public List<InstructorResponse> getAllInstructor() {
        return instructorRepository.getAllInstructor();
    }

    @Override
    public List<InstructorDetailsResponse> getAllInfoInstructor(Long id) {
        return instructorRepository.getAllInstructorsDetails(id);
    }

    @Override
    public InstructorResponse getInstructorId(Long id) {
        return instructorRepository.getInstructorId(id).orElseThrow(() -> new NullPointerException("Instructor with id: " + id + "not found"));
    }

    @Override
    public SimpleResponse update(Long id, InstructorRequest instructorRequest) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new NullPointerException("Instructor with id: " + id + "not found"));
        instructor.setFirst_name(instructorRequest.getFirst_name());
        instructor.setLast_name(instructorRequest.getLast_name());
        instructor.setPhone_number(instructorRequest.getPhone_number());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructorRepository.save(instructor);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Update Instructor")
                .build();
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        instructorRepository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("delete Instructor")
                .build();
    }

    @Override
    public SimpleResponse assignInstructorToCompany(AssignRequest assignRequest) {
        Instructor instructor = instructorRepository.findById(assignRequest.getInstructorId()).orElseThrow(
                () -> new NullPointerException("Instructor with id: " + assignRequest.getInstructorId() + " not found"));
        Company company = companyRepository.findById(assignRequest.getCompanyId()).orElseThrow(
                () -> new NullPointerException("Course with id: " + assignRequest.getCompanyId() + " not found"));
        instructor.getCompanies().add(company);
        company.getInstructors().add(instructor);
        instructorRepository.save(instructor);
        companyRepository.save(company);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Assign ")
                .build();
    }

    @Override
    public SimpleResponse assignInstructorToCourse(AssignCourseRequest assignCourseRequest) {
        Instructor instructor = instructorRepository.findById(assignCourseRequest.getInstructorId()).orElseThrow(
                () -> new NullPointerException("Instructor with id: " + assignCourseRequest.getInstructorId() + " not found"));
        Course course = courseRepository.findById(assignCourseRequest.getCourseId()).orElseThrow(
                () -> new NullPointerException("Course with id: " + assignCourseRequest.getCourseId() + " not found"));
        instructor.getCourses().add(course);
        course.setInstructor(instructor);
        courseRepository.save(course);
        instructorRepository.save(instructor);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Assign ")
                .build();
    }
}

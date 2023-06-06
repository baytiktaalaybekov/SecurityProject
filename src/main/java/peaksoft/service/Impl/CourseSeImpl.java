package com.example.securityproject.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.repository.CompanyRepository;
import peaksoft.repository.CourseRepository;
import peaksoft.service.CourseSe;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseSeImpl implements CourseSe {


    private final CourseRepository courseRepository;

    private final CompanyRepository companyRepository;


    @Override
    public SimpleResponse saveCourse(Long companyId, CourseRequest courseRequest) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new NullPointerException("Company with id: " + companyId + "not found"));
        Course course = new Course();
        course.setCourse_name(courseRequest.getCourse_name());
        course.setDate_of_start(courseRequest.getDate_of_start());
        course.setDescription(courseRequest.getDescription());
        company.addCourse(course);
        course.setCompany(company);
        courseRepository.save(course);
        return SimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message("Save Course")
                .build();
    }

    @Override
    public List<CourseResponse> getAllCourse(String ascOrDesc) {
        return courseRepository.getAllCourse(ascOrDesc);
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        return courseRepository.getCourseById(id).orElseThrow(()-> new RuntimeException("Course with id: "+id+"not found!"));
    }

    @Override
    public SimpleResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course with id: " + id + "not found!"));
        course.setCourse_name(courseRequest.getCourse_name());
        course.setDate_of_start(courseRequest.getDate_of_start());
        course.setDescription(courseRequest.getDescription());
        courseRepository.save(course);
        return SimpleResponse.builder()
                .status(HttpStatus.OK).message("Update Course").build();
    }

    @Override
    public SimpleResponse deleteCourse(Long id) {
        courseRepository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Delete Course")
                .build();
    }
}

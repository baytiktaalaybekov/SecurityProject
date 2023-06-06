package com.example.securityproject.service;

import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.dto.response.SimpleResponse;

import java.util.List;

public interface CourseSe {

    SimpleResponse saveCourse(Long companyId, CourseRequest courseRequest);

    List<CourseResponse> getAllCourse(String ascOrDesc);

    CourseResponse getCourseById(Long id);

    SimpleResponse updateCourse(Long id, CourseRequest courseRequest);

    SimpleResponse deleteCourse (Long id);


}

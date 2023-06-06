package com.example.securityproject.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.service.CourseSe;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseApi {

    private final CourseSe courseSe;

    @GetMapping
    public List<CourseResponse> getAllCourse(@RequestParam String ascOrDesc){
        return courseSe.getAllCourse(ascOrDesc);
    }

    @PostMapping("/{companyId}")
    public SimpleResponse saveCourse(@Valid @PathVariable Long companyId, @RequestBody CourseRequest courseRequest){
        return courseSe.saveCourse(companyId,courseRequest);
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable Long id){
        return courseSe.getCourseById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse updateCourse(@Valid @PathVariable Long id,@RequestBody CourseRequest courseRequest){
        return courseSe.updateCourse(id, courseRequest);
    }


    @DeleteMapping("/{id}")
    public SimpleResponse deleteCourse(@PathVariable Long id){
        return courseSe.deleteCourse(id);
    }
}

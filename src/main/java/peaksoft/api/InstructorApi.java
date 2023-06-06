package com.example.securityproject.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.AssignCourseRequest;
import peaksoft.dto.request.AssignRequest;
import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.response.InstructorDetailsResponse;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.service.InstructorSe;

import java.util.List;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorApi {

    private final InstructorSe instructorSe;

    @GetMapping
    public List<InstructorResponse> getAllInstructor(){
        return instructorSe.getAllInstructor();
    }

    @PostMapping
    public SimpleResponse save(@Valid @RequestBody InstructorRequest instructorRequest){
        return instructorSe.saveInstructor(instructorRequest);
    }

    @GetMapping("/{id}")
    public InstructorResponse getInstructorById(@PathVariable Long id){
        return instructorSe.getInstructorId(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse update(@Valid @PathVariable Long id,@RequestBody InstructorRequest instructorRequest){
        return instructorSe.update(id,instructorRequest);
    }


    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable Long id){
        return instructorSe.deleteById(id);
    }


    @PostMapping("/assign")
    public SimpleResponse assign (@RequestBody AssignRequest assignRequest){
        return instructorSe.assignInstructorToCompany(assignRequest);
    }

    @GetMapping("/{id}/info")
    public List<InstructorDetailsResponse> getAllInstructorInfo(@PathVariable Long id){
        return instructorSe.getAllInfoInstructor(id);
    }

    @PostMapping("/assignCourse")
    public SimpleResponse assignInstructorToCourse(@RequestBody AssignCourseRequest assignCourseRequest) {
        return instructorSe.assignInstructorToCourse(assignCourseRequest);
    }



}

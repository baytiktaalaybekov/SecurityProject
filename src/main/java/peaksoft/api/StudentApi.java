package com.example.securityproject.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.StudentResponse;
import peaksoft.enums.StudyFormat;
import peaksoft.service.StudentSe;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentApi {

    private final StudentSe studentSe;


    @GetMapping
    public List<StudentResponse> getAllStudent(){
        return studentSe.getAllStudent();
    }

    @PostMapping
    public StudentResponse save(@Valid @RequestBody StudentRequest studentRequest){
        return studentSe.saveStudent(studentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id){
        return studentSe.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponse update(@Valid @PathVariable Long id,@RequestBody StudentRequest studentRequest){
        return studentSe.update(id,studentRequest);
    }
    @DeleteMapping("{id}")
    public SimpleResponse delete(@PathVariable Long id){
        return studentSe.deleteStudent(id);
    }


    @PostMapping("/{studentId}")
    public SimpleResponse blockUnBlock(@PathVariable Long studentId,@RequestParam Boolean block ){
        return studentSe.blockUnblockStudent(studentId,block);
    }

    @GetMapping("/filter")
    public  List<StudentResponse>filterStudent(@RequestParam (required = false) StudyFormat studyFormat){
        return studentSe.findByStudyFormat(studyFormat);
    }

    @PostMapping("/{studentId}/{groupId}")
    public SimpleResponse assign (@PathVariable Long studentId,@PathVariable Long groupId){
        return studentSe.assignStudentsToGroup(studentId,groupId);
    }
}

package com.example.securityproject.service;

import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.StudentResponse;
import peaksoft.enums.StudyFormat;

import java.util.List;

public interface StudentSe {

    StudentResponse saveStudent(StudentRequest studentRequest);

    List<StudentResponse> getAllStudent();

    StudentResponse getStudentById(Long id);

    StudentResponse update(Long studentId,StudentRequest studentRequest);

    SimpleResponse deleteStudent(Long id);


    SimpleResponse blockUnblockStudent(Long studentId,Boolean block);

    List<StudentResponse>findByStudyFormat(StudyFormat studyFormat);

    SimpleResponse assignStudentsToGroup(Long studentId, Long groupId);

}

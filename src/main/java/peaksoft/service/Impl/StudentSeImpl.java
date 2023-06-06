package com.example.securityproject.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entity.Group;
import peaksoft.entity.Student;
import peaksoft.enums.StudyFormat;
import peaksoft.repository.GroupRepository;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentSe;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentSeImpl implements StudentSe {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
         Student student = new Student();
    student.setFirstName(studentRequest.getFirstName());
    student.setLastName(studentRequest.getLastName());
    student.setEmail(studentRequest.getEmail());
    student.setPhoneNumber(studentRequest.getPhoneNumber());
    student.setStudyFormat(studentRequest.getStudyFormat());
    student.setIsBlocked(false);
    studentRepository.save(student);
    return new StudentResponse(
            student.getId(),
            student.getFirstName(),
            student.getLastName(),
            student.getEmail(),
            student.getPhoneNumber(),
            student.getStudyFormat(),
            student.getIsBlocked()
    );


    }

    @Override
    public List<StudentResponse> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return studentRepository.getStudentById(id).orElseThrow(()-> new NullPointerException("Student with id: " +id+ "Not Found"));
    }

    @Override
    public StudentResponse update(Long studentId, StudentRequest studentRequest) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new RuntimeException("Student with id : " + studentId + " doesn't exist"));
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
        student.setIsBlocked(false);
        studentRepository.save(student);
        return StudentResponse.builder()
                .id(student.getId())
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .phoneNumber(studentRequest.getPhoneNumber())
                .email(studentRequest.getEmail())
                .studyFormat(studentRequest.getStudyFormat())
                .build();
    }


    @Override
    public SimpleResponse deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Delete Student")
                .build();
    }


    @Override
    public SimpleResponse blockUnblockStudent(Long studentId, Boolean block) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new NullPointerException("Student with id: " + studentId + "Not Found"));
        student.setIsBlocked(block);
        studentRepository.save(student);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Block Student")
                .build();
    }

    @Override
    public List<StudentResponse> findByStudyFormat(StudyFormat studyFormat) {
        return studentRepository.findByStudyFormat(studyFormat);
    }



    @Override
    public SimpleResponse assignStudentsToGroup(Long studentId, Long groupId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new RuntimeException("Student with id : " + studentId + " doesn't exist"));
        Group group= groupRepository.findById(groupId).orElseThrow(() ->
                new RuntimeException("Student with id : " +groupId + " doesn't exist"));
        group.getStudents().add(student);
        student.setGroup(group);
        studentRepository.save(student);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Assign")
                .build();
    }


}

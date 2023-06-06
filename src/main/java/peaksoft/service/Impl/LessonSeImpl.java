package com.example.securityproject.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.LessonRequest;
import peaksoft.dto.response.LessonResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.LessonRepository;
import peaksoft.service.LessonSe;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LessonSeImpl implements LessonSe {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    @Override
    public SimpleResponse save(Long courseId, LessonRequest lessonRequest) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new NullPointerException("Course with id: " + courseId + "Not found"));
        Lesson lesson = new Lesson();
        lesson.setLesson_name(lessonRequest.getLesson_name());
        lesson.setDescription(lessonRequest.getDescription());
        lesson.setCourse(course);
        lessonRepository.save(lesson);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Save Lesson")
                .build();

    }

    @Override
    public List<LessonResponse> getAllLesson() {
        return lessonRepository.getAllLesson();
    }

    @Override
    public LessonResponse getLessonById(Long id) {
        return lessonRepository.getLessonById(id).orElseThrow(
                () -> new NullPointerException("Lesson with id: " + id + "Not found"));
    }

    @Override
    public SimpleResponse update(Long id, LessonRequest lessonRequest) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(
                () -> new NullPointerException("Lesson with id: " + id + "Not found"));
        lesson.setLesson_name(lessonRequest.getLesson_name());
        lessonRepository.save(lesson);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Update Lesson")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        lessonRepository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Delete Lesson")
                .build();
    }
}

package com.example.securityproject.service;

import peaksoft.dto.request.LessonRequest;
import peaksoft.dto.response.LessonResponse;
import peaksoft.dto.response.SimpleResponse;

import java.util.List;

public interface LessonSe {

    SimpleResponse save(Long courseId, LessonRequest lessonRequest);

    List<LessonResponse> getAllLesson();

    LessonResponse getLessonById(Long id);

    SimpleResponse update(Long id, LessonRequest lessonRequest);

    SimpleResponse delete (Long id);


}

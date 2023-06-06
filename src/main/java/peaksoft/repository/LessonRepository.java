package com.example.securityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.LessonResponse;
import peaksoft.entity.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query("select new peaksoft.dto.response.LessonResponse(l.id,l.lesson_name,l.description)from Lesson l")
    List<LessonResponse> getAllLesson();

    @Query("select new peaksoft.dto.response.LessonResponse(l.id,l.lesson_name,l.description)from Lesson l where l.id=:id")
    Optional<LessonResponse> getLessonById(Long id);
}
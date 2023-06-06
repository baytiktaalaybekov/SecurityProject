package com.example.securityproject.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.LessonRequest;
import peaksoft.dto.response.LessonResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.service.LessonSe;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonApi {

    private final LessonSe lessonSe;


    @GetMapping
    public List<LessonResponse> getAllLessons() {
        return lessonSe.getAllLesson();
    }

    @PostMapping("/{courseId}")
    public SimpleResponse save(@Valid @PathVariable Long courseId, @RequestBody LessonRequest lessonRequest){
        return lessonSe.save(courseId,lessonRequest);
    }


    @GetMapping("/{id}")
    public LessonResponse getById(@PathVariable Long id){
        return lessonSe.getLessonById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse update(@Valid @PathVariable Long id,@RequestBody LessonRequest lessonRequest){
        return lessonSe.update(id,lessonRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable Long id){
        return lessonSe.delete(id);
    }

}

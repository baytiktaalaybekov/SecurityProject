package com.example.securityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.dto.response.CourseResponse;
import peaksoft.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {


    @Query("select new peaksoft.dto.response.CourseResponse(c.id, c.course_name, c.date_of_start, c.description) " +
            "from Course c " +
            "order by case when :ascOrDesc = 'asc' then c.date_of_start end asc, " +
            "case when :ascOrDesc = 'desc' then c.date_of_start end desc")
    List<CourseResponse> getAllCourse(@Param("ascOrDesc") String ascOrDesc);

    @Query("select new peaksoft.dto.response.CourseResponse(c.id,c.course_name,c.date_of_start,c.description)from Course c where c.id=:id")
    Optional<CourseResponse> getCourseById(Long id);
}
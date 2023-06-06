package com.example.securityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.TaskResponse;
import peaksoft.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("select new peaksoft.dto.response.TaskResponse(t.id,t.task_name,t.taskText,t.dead_line)from Task t")
    List<TaskResponse> getAllTask();

    @Query("select new peaksoft.dto.response.TaskResponse(t.id,t.task_name,t.taskText,t.dead_line)from Task t where t.id=:id")
    Optional<TaskResponse> getTaskById(Long id);

}
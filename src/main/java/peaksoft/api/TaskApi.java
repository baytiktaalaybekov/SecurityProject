package com.example.securityproject.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.TaskRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.TaskResponse;
import peaksoft.service.TaskSe;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskApi {

    private final TaskSe taskSe;

    @GetMapping
    public List<TaskResponse> getAllTask(){
        return taskSe.getAllTask();
    }

    @PostMapping("/{lessonId}")
    public SimpleResponse saveTask(@Valid @PathVariable Long lessonId, @RequestBody TaskRequest taskRequest){
        return taskSe.save(lessonId, taskRequest);
    }

    @GetMapping("/{id}")
    public TaskResponse getById(@PathVariable Long id){
        return taskSe.getTaskById(id);
    }


    @PutMapping("/{id}")
    public SimpleResponse update(@Valid @PathVariable Long id,@RequestBody TaskRequest taskRequest){
        return taskSe.update(id, taskRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteTask(Long id){
        return taskSe.deleteTask(id);


    }
}

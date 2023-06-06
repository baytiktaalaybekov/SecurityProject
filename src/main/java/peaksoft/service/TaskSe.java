package com.example.securityproject.service;

import peaksoft.dto.request.TaskRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.TaskResponse;

import java.util.List;

public interface TaskSe {

    SimpleResponse save(Long lessonId, TaskRequest taskRequest);

    List<TaskResponse> getAllTask();

    TaskResponse getTaskById(Long id);

    SimpleResponse update(Long id, TaskRequest taskRequest);

    SimpleResponse deleteTask (Long id);
}

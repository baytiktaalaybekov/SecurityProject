package com.example.securityproject.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.TaskRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.TaskResponse;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repository.LessonRepository;
import peaksoft.repository.TaskRepository;
import peaksoft.service.TaskSe;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskSeImpl implements TaskSe {

    private final TaskRepository taskRepository;
    private final LessonRepository lessonRepository;

    @Override
    public SimpleResponse save(Long lessonId, TaskRequest taskRequest) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() -> new NullPointerException("Lesson with id: " + lessonId + " not found"));
        Task task = new Task();
        task.setTask_name(taskRequest.getTask_name());
        task.setTaskText(taskRequest.getTaskText());
        task.setDead_line(taskRequest.getDead_line());
        lesson.addTask(task);
        task.setLesson(lesson);
        taskRepository.save(task);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Save Task")
                .build();
    }

    @Override
    public List<TaskResponse> getAllTask() {
        return taskRepository.getAllTask();
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        return taskRepository.getTaskById(id).orElseThrow(() -> new NullPointerException("Lesson with id: " + id + " not found"));
    }

    @Override
    public SimpleResponse update(Long id, TaskRequest taskRequest) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NullPointerException("Lesson with id: " + id + " not found"));
        task.setTask_name(taskRequest.getTask_name());
        task.setTaskText(taskRequest.getTaskText());
        task.setDead_line(taskRequest.getDead_line());
        taskRepository.save(task);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Update Task")
                .build();
    }

    @Override
    public SimpleResponse deleteTask(Long id) {
        taskRepository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Delete Task")
                .build();
    }
}

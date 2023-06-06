package com.example.securityproject.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.AssignGroupToCourseRequest;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.GroupRepository;
import peaksoft.service.GroupSe;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupSeImpl implements GroupSe {

    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    @Override
    public SimpleResponse saveGroup(GroupRequest groupRequest) {
        Group group = new Group();
        group.setGroup_name(groupRequest.getGroup_name());
        group.setImage_Link(groupRequest.getImage_Link());
        group.setDescription(groupRequest.getDescription());
        groupRepository.save(group);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Save Group")
                .build();
    }


    @Override
    public List<GroupResponse> getAllGroup() {
        return groupRepository.getAllGroup();
    }

    @Override
    public GroupResponse getGroupById(Long id) {
        return groupRepository.getGroupById(id).orElseThrow(() -> new RuntimeException("Group with id: " + id + "not found"));
    }

    @Override
    public SimpleResponse update(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group with id: " + id + "not found"));
        group.setGroup_name(groupRequest.getGroup_name());
        group.setImage_Link(groupRequest.getImage_Link());
        group.setDescription(groupRequest.getDescription());
        groupRepository.save(group);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Update Group")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        groupRepository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("delete Group")
                .build();
    }

    @Override
    public SimpleResponse assignGroupToCourse(AssignGroupToCourseRequest assignGroupRequest) {
        Group group = groupRepository.findById(assignGroupRequest.getGroupId()).orElseThrow(
                () -> new RuntimeException("Group with id: " + assignGroupRequest.getGroupId() + "not found"));
        Course course = courseRepository.findById(assignGroupRequest.getCourseId()).orElseThrow(
                () -> new RuntimeException("Course with id: " + assignGroupRequest.getCourseId() + "not found"));
        group.getCourses().add(course);
        course.getGroups().add(group);
        groupRepository.save(group);
        courseRepository.save(course);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("assign Group")
                .build();
    }



}

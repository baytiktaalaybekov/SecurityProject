package com.example.securityproject.service;

import peaksoft.dto.request.AssignGroupToCourseRequest;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.dto.response.SimpleResponse;

import java.util.List;

public interface GroupSe {

    SimpleResponse saveGroup(GroupRequest groupRequest);

    List<GroupResponse> getAllGroup();

    GroupResponse getGroupById(Long id);

    SimpleResponse update(Long id,GroupRequest groupRequest);

    SimpleResponse delete(Long id);

    SimpleResponse assignGroupToCourse(AssignGroupToCourseRequest assignGroupRequest);

}

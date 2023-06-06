package com.example.securityproject.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.AssignGroupToCourseRequest;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.service.GroupSe;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupApi {

    private final GroupSe groupSe;

    @GetMapping
    public List<GroupResponse> getAllGroup(){
        return groupSe.getAllGroup();
    }

    @PostMapping
   public SimpleResponse save(@Valid @RequestBody GroupRequest groupRequest){
        return groupSe.saveGroup(groupRequest);
    }

    @GetMapping("/{id}")
    public GroupResponse getById(@PathVariable Long id){
        return groupSe.getGroupById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse update(@Valid @PathVariable Long id,@RequestBody GroupRequest groupRequest){
        return groupSe.update(id, groupRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable Long id){
        return groupSe.delete(id);
    }

    @PostMapping("/assign")
    public SimpleResponse assign(@RequestBody AssignGroupToCourseRequest assignGroupRequest){
        return groupSe.assignGroupToCourse(assignGroupRequest);
    }


}

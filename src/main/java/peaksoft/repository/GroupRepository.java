package com.example.securityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("select new peaksoft.dto.response.GroupResponse(g.id,g.group_name,g.image_Link,g.description)from Group g")
    List<GroupResponse> getAllGroup();

    @Query("select new peaksoft.dto.response.GroupResponse(g.id,g.group_name,g.image_Link,g.description)from Group g where g.id=:id")
    Optional<GroupResponse> getGroupById(Long id);




//
}
package com.example.securityproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
@Getter @Setter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    @SequenceGenerator(name = "group_seq",sequenceName = "group_id_gen",allocationSize = 1)
    private Long id;
    @NotEmpty(message = "fill in the field")
    private String group_name;
    @Column(length = 10000000)
    private String image_Link;
    @NotEmpty(message = "fill in the field")
    private String description;

    @OneToMany(mappedBy = "group", cascade = ALL)
    private List <Student> students;

    @ManyToMany(mappedBy = "groups", cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private List<Course> courses;


}
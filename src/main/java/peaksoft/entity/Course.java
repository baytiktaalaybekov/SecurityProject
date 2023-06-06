package com.example.securityproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@Getter @Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq",sequenceName = "course_id_gen",allocationSize = 1)
    private Long id;
    @NotEmpty(message = "fill in the field")
    private String course_name;

    private LocalDate date_of_start;
    @NotEmpty(message = "fill in the field")
    private String description;

    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private Company company;

    @ManyToMany(cascade = ALL)
    private List<Group>groups;

    @OneToMany(mappedBy = "course", cascade = ALL)
    private List<Lesson> lessons;

    @ManyToOne( cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private Instructor instructor;



}
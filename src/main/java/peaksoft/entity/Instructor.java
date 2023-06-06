package com.example.securityproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_seq")
    @SequenceGenerator(name = "instructor_seq", sequenceName = "instructor_id_gen", allocationSize = 1)
    private Long id;

    @NotEmpty(message = "fill in the field")
    private String first_name;
    @NotEmpty(message = "fill in the field")
    private String last_name;

    @NotEmpty(message = "fill in the field")
    @Pattern(regexp = "\\+996\\d{9}",message = "Wrong format")
    private String phone_number;

    @NotEmpty(message = "fill in the field")
    private String specialization;

    @ManyToMany( cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private List<Company> companies;

    @OneToMany(cascade = {REFRESH, DETACH, MERGE, PERSIST}, mappedBy = "instructor")
    private List<Course> courses = new ArrayList<>() ;




}
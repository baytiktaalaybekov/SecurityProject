package com.example.securityproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.StudyFormat;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "students")
@Getter @Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(generator = "student_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq", allocationSize = 1)
    private Long id;
    @NotEmpty(message = "fill in the field")
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "fill in the field")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "fill in the field")
    @Pattern(regexp = "\\+996\\d{9}",message = "Wrong format")
    private String phoneNumber;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    private Boolean isBlocked;

    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private Group group;



}
package com.example.securityproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "companies")
@Getter @Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    @SequenceGenerator(name = "company_seq",sequenceName = "company_id_gen",allocationSize = 1)
    private Long id;

    @NotEmpty(message = "fill in the field")
    @Column(unique = true)
    private String name;
    @NotEmpty(message = "fill in the field")
    private String country;
    @NotEmpty(message = "fill in the field")
    private String address;

    @NotEmpty(message = "fill in the field")
    @Pattern(regexp = "\\+996\\d{9}",message = "Wrong format")
    private String phone_number;

    @ManyToMany(mappedBy = "companies",cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private List<Instructor> instructors;

    @OneToMany(mappedBy = "company", cascade = ALL)
    private List<Course> courses;


    public void addCourse(Course course) {
        courses.add(course);
    }
}
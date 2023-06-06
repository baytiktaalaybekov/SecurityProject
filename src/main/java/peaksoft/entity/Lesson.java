package com.example.securityproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "lessons")
@Getter @Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_seq")
    @SequenceGenerator(name = "lesson_seq",sequenceName = "lesson_id_gen",allocationSize = 1)
    private Long id;

    @NotEmpty(message = "fill in the field")
    private String lesson_name;
    @NotEmpty(message = "fill in the field")
    private String description;

    @OneToMany(mappedBy = "lesson", cascade ={ PERSIST,REFRESH, DETACH, MERGE} )
    private List<Task> tasks;

    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private Course course;


    public void addTask(Task task) {
        tasks.add(task);
    }
}
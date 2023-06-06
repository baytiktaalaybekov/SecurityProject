package com.example.securityproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq",sequenceName = "task_id_gen",allocationSize = 1)
    private Long id;
    @NotEmpty(message = "fill in the field")
    private String task_name;
    @NotEmpty(message = "fill in the field")
    private String taskText;

    private LocalDate dead_line;

    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private Lesson lesson;

}

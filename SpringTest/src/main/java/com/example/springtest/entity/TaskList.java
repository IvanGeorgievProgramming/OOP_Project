package com.example.springtest.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "taskList")
    private List<Task> tasks;

    // Constructors, getters, and setters
}

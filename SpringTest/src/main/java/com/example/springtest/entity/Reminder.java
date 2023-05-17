package com.example.springtest.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Task task;

    private LocalDateTime dateTime;

    private String notificationMethod;

    // Constructors, getters, and setters
}

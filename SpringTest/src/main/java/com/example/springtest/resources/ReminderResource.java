package com.example.springtest.resources;

import com.example.springtest.entity.Task;
import jakarta.annotation.Resource;
import lombok.Data;

import java.time.LocalDateTime;

@Resource
@Data
public class ReminderResource {
    private Long id;
    private Task task;
    private LocalDateTime dateTime;
    private String notificationMethod;
}

package com.example.springtest.services;

import com.example.springtest.entity.Task;
import java.util.List;

public interface TaskService {
    List<Task> allTasks();
    Task findById(Long id);
    Task save(Task task);
    Task update(Task task);
    void deleteById(Long id);
}

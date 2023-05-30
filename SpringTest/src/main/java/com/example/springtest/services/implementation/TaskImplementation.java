package com.example.springtest.services.implementation;

import com.example.springtest.entity.Task;
import com.example.springtest.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.springtest.services.TaskService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskImplementation implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public List<Task> allTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        Task existingTask = taskRepository.findById(task.getId()).orElse(null);
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setPriority(task.getPriority());
            existingTask.setCategory(task.getCategory());
            existingTask.setComments(task.getComments());
            return taskRepository.save(existingTask);
        }
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
}

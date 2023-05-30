package com.example.springtest.services.implementation;

import com.example.springtest.entity.TaskList;
import com.example.springtest.repository.TaskListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.springtest.services.TaskListService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskListImplementation implements TaskListService {
    private final TaskListRepository taskListRepository;

    @Override
    public List<TaskList> allTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList save(TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    @Override
    public TaskList update(TaskList taskList) {
        TaskList existingTaskList = taskListRepository.findById(taskList.getId()).orElse(null);
        if (existingTaskList != null) {
            existingTaskList.setName(taskList.getName());
            existingTaskList.setOwner(taskList.getOwner());
            existingTaskList.setTasks(taskList.getTasks());
            return taskListRepository.save(existingTaskList);
        }
        return taskListRepository.save(taskList);
    }

    @Override
    public void deleteById(Long id) {
        taskListRepository.deleteById(id);
    }

    @Override
    public TaskList findById(Long id) {
        return taskListRepository.findById(id).orElse(null);
    }
}

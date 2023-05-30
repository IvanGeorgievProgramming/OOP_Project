package com.example.springtest.services;
import com.example.springtest.entity.TaskList;
import java.util.List;

public interface TaskListService {
    List<TaskList> allTaskLists();
    TaskList findById(Long id);
    TaskList save(TaskList taskList);
    TaskList update(TaskList taskList);
    void deleteById(Long id);
}

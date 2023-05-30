package com.example.springtest.resources;

import com.example.springtest.entity.Task;
import com.example.springtest.entity.User;
import jakarta.annotation.Resource;
import lombok.Data;

import java.util.List;

@Resource
@Data
public class TaskListResource {
    private Long id;
    private String name;
    private User owner;
    private List<Task> tasks;
}

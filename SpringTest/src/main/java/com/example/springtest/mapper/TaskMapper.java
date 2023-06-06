package com.example.springtest.mapper;

import com.example.springtest.resources.TaskResource;
import com.example.springtest.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TaskMapper {
    TaskMapper TASK_MAPPER = Mappers.getMapper(TaskMapper.class);

    Task fromTaskResource(TaskResource taskResource);

    TaskResource toTaskResource(Task task);

    List<TaskResource> toTaskResources(List<Task> tasks);
}

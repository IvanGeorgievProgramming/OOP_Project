package com.example.springtest.mapper;

import com.example.springtest.resources.TaskListResource;
import com.example.springtest.entity.TaskList;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TaskListMapper {
    TaskListMapper TASKLIST_MAPPER = Mappers.getMapper(TaskListMapper.class);

    TaskList fromTaskListResource(TaskListResource taskListResource);

    TaskListResource toTaskListResource(TaskList taskList);

    List<TaskListResource> toTaskListResources(List<TaskList> taskLists);
}

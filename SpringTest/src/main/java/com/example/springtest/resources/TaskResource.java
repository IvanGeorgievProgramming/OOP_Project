package com.example.springtest.resources;

import com.example.springtest.entity.Category;
import com.example.springtest.entity.Comment;
import jakarta.annotation.Resource;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Resource
@Data
public class TaskResource {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Long priority;
    private Category category;
    private List<Comment> comments;
}

package com.example.springtest.resources;

import com.example.springtest.entity.Task;
import com.example.springtest.entity.User;
import jakarta.annotation.Resource;
import lombok.Data;

@Resource
@Data
public class CommentResource {
    private Long id;
    private Task task;
    private User user;
    private String content;
}

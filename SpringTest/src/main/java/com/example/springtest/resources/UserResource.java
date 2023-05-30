package com.example.springtest.resources;

import jakarta.annotation.Resource;
import lombok.Data;

@Resource
@Data
public class UserResource {
    private Long id;
    private String username;
    private String password;
}

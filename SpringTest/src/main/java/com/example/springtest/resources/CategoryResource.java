package com.example.springtest.resources;

import jakarta.annotation.Resource;
import lombok.Data;

@Resource
@Data
public class CategoryResource {
    private Long id;
    private String name;
}

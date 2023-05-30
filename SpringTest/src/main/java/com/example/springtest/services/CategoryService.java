package com.example.springtest.services;

import com.example.springtest.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> AllCategories();
    Category findById(Long id);
    Category save(Category category);
    Category update(Category category);
    void deleteById(Long id);
}

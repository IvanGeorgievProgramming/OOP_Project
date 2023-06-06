package com.example.springtest.mapper;

import com.example.springtest.resources.CategoryResource;
import com.example.springtest.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    Category fromCategoryResource(CategoryResource categoryResource);

    CategoryResource toCategoryResource(Category category);

    List<CategoryResource> toCategoryResources(List<Category> categories);
}

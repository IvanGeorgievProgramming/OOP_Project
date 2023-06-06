package com.example.springtest.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.springtest.resources.CategoryResource;
import com.example.springtest.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<CategoryResource> categoryResource = categoryService.getById(id);

        if (categoryResource.isPresent()) {
            return ResponseEntity.ok(categoryResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find category with id " + id + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CategoryResource categoryResource) {
        CategoryResource createdCategory = categoryService.create(categoryResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/categories/{id}").buildAndExpand(createdCategory.getId()).toUri()
        ).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody CategoryResource categoryResource, @PathVariable("id") Long id) {
        return ResponseEntity.ok(categoryService.update(categoryResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

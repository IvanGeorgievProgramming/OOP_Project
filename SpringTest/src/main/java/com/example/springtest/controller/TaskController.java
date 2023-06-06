package com.example.springtest.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.springtest.resources.TaskResource;
import com.example.springtest.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<TaskResource> taskResource = taskService.getById(id);

        if (taskResource.isPresent()) {
            return ResponseEntity.ok(taskResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find task with id " + id + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TaskResource taskResource) {
        TaskResource createdTask = taskService.create(taskResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/tasks/{id}").buildAndExpand(createdTask.getId()).toUri()
        ).body(createdTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody TaskResource taskResource, @PathVariable("id") Long id) {
        return ResponseEntity.ok(taskService.update(taskResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

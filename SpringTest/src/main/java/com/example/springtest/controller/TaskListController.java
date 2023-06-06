package com.example.springtest.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.springtest.resources.TaskListResource;
import com.example.springtest.services.TaskListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/tasklists")
@RequiredArgsConstructor
public class TaskListController {
    private final TaskListService taskListService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(taskListService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<TaskListResource> taskListResource = taskListService.getById(id);

        if (taskListResource.isPresent()) {
            return ResponseEntity.ok(taskListResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find task list with id " + id + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TaskListResource taskListResource) {
        TaskListResource createdTaskList = taskListService.create(taskListResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/tasklists/{id}").buildAndExpand(createdTaskList.getId()).toUri()
        ).body(createdTaskList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody TaskListResource taskListResource, @PathVariable("id") Long id) {
        return ResponseEntity.ok(taskListService.update(taskListResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        taskListService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.springtest.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.springtest.resources.ReminderResource;
import com.example.springtest.services.ReminderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/reminders")
@RequiredArgsConstructor
public class ReminderController {
    private final ReminderService reminderService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(reminderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<ReminderResource> reminderResource = reminderService.getById(id);

        if (reminderResource.isPresent()) {
            return ResponseEntity.ok(reminderResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find reminder with id " + id + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ReminderResource reminderResource) {
        ReminderResource createdReminder = reminderService.create(reminderResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/reminders/{id}").buildAndExpand(createdReminder.getId()).toUri()
        ).body(createdReminder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody ReminderResource reminderResource, @PathVariable("id") Long id) {
        return ResponseEntity.ok(reminderService.update(reminderResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        reminderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

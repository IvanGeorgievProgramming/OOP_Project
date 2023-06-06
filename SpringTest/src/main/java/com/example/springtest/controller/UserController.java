package com.example.springtest.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.springtest.resources.UserResource;
import com.example.springtest.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<UserResource> userResource = userService.getById(id);

        if (userResource.isPresent()) {
            return ResponseEntity.ok(userResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find user with id " + id + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserResource userResource) {
        UserResource createdUser = userService.create(userResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/users/{id}").buildAndExpand(createdUser.getId()).toUri()
        ).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody UserResource userResource, @PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.update(userResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>

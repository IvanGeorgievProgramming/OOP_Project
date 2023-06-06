package com.example.springtest.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.springtest.resources.CommentResource;
import com.example.springtest.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(commentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<CommentResource> commentResource = commentService.getById(id);

        if (commentResource.isPresent()) {
            return ResponseEntity.ok(commentResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find comment with id " + id + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CommentResource commentResource) {
        CommentResource createdComment = commentService.create(commentResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/comments/{id}").buildAndExpand(createdComment.getId()).toUri()
        ).body(createdComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody CommentResource commentResource, @PathVariable("id") Long id) {
        return ResponseEntity.ok(commentService.update(commentResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

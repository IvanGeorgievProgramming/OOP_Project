package com.example.springtest.services.implementation;

import com.example.springtest.entity.Comment;
import com.example.springtest.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.springtest.services.CommentService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentImplementation implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> allComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        Comment existingComment = commentRepository.findById(comment.getId()).orElse(null);
        if (existingComment != null) {
            existingComment.setTask(comment.getTask());
            existingComment.setUser(comment.getUser());
            existingComment.setContent(comment.getContent());
            return commentRepository.save(existingComment);
        }
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }
}

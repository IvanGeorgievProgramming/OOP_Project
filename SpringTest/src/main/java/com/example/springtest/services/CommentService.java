package com.example.springtest.services;

import com.example.springtest.entity.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> allComments();
    Comment findById(Long id);
    Comment save(Comment comment);
    Comment update(Comment comment);
    void deleteById(Long id);
}

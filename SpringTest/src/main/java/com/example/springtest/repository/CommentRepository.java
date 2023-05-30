package com.example.springtest.repository;

import com.example.springtest.entity.Comment;
import com.example.springtest.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTask(Task task);
    // Additional custom query methods can be defined here
}


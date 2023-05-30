package com.example.springtest.repository;

import com.example.springtest.entity.Task;
import jakarta.annotation.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitle(String title);
    List<Task> findByDueDate(LocalDate dueDate);
    List<Task> findByPriority(Priority priority);
    // Additional custom query methods can be defined here
}

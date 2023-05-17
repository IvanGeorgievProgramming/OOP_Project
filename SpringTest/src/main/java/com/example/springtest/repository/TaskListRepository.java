package com.example.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    // Additional custom query methods can be defined here
}

package com.example.springtest.repository;

import com.example.springtest.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    // Additional custom query methods can be defined here
}

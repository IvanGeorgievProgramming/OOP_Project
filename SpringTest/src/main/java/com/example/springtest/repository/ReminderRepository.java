package com.example.springtest.repository;

import com.example.springtest.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByDateTimeBefore(LocalDateTime dateTime);
    // Additional custom query methods can be defined here
}


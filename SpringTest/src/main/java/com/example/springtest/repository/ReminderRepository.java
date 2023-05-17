package com.example.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByDateTimeBefore(LocalDateTime dateTime);
    // Additional custom query methods can be defined here
}


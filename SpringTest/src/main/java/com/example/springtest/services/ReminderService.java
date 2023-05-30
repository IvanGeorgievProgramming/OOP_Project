package com.example.springtest.services;

import com.example.springtest.entity.Reminder;
import java.util.List;

public interface ReminderService {
    List<Reminder> allReminders();
    Reminder findById(Long id);
    Reminder save(Reminder reminder);
    Reminder update(Reminder reminder);
    void deleteById(Long id);
}

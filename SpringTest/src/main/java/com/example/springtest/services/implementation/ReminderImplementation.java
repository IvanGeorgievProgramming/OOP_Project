package com.example.springtest.services.implementation;

import com.example.springtest.entity.Reminder;
import com.example.springtest.repository.ReminderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.springtest.services.ReminderService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReminderImplementation implements ReminderService {
    private final ReminderRepository reminderRepository;

    @Override
    public List<Reminder> allReminders() {
        return reminderRepository.findAll();
    }

    @Override
    public Reminder save(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    @Override
    public Reminder update(Reminder reminder) {
        Reminder existingReminder = reminderRepository.findById(reminder.getId()).orElse(null);
        if (existingReminder != null) {
            existingReminder.setTask(reminder.getTask());
            existingReminder.setDateTime(reminder.getDateTime());
            existingReminder.setNotificationMethod(reminder.getNotificationMethod());
            return reminderRepository.save(existingReminder);
        }
        return reminderRepository.save(reminder);
    }

    @Override
    public void deleteById(Long id) {
        reminderRepository.deleteById(id);
    }

    @Override
    public Reminder findById(Long id) {
        return reminderRepository.findById(id).orElse(null);
    }
}

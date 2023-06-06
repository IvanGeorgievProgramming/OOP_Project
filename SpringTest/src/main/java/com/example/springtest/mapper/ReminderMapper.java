package com.example.springtest.mapper;

import com.example.springtest.resources.ReminderResource;
import com.example.springtest.entity.Reminder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReminderMapper {
    ReminderMapper REMINDER_MAPPER = Mappers.getMapper(ReminderMapper.class);

    Reminder fromReminderResource(ReminderResource reminderResource);

    ReminderResource toReminderResource(Reminder reminder);

    List<ReminderResource> toReminderResources(List<Reminder> reminders);
}

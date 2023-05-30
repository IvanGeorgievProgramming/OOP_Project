package com.example.springtest.services;

import com.example.springtest.entity.User;
import java.util.List;

public interface UserService {
    List<User> allUsers();
    User findById(Long id);
    User save(User user);
    User update(User user);
    void deleteById(Long id);
}

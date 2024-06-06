package com.example.demo.service.userService;

import com.example.demo.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void remove(Long id);
}

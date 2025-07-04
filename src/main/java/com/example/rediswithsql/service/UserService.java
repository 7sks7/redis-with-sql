package com.example.rediswithsql.service;

import com.example.rediswithsql.model.User;

public interface UserService {
    User getById(String id);
    User saveUser(User user);
    String deleteUser(String id);
    User updateUser(String id, User user);
}

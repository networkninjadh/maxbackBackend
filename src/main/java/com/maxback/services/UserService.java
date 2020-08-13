package com.maxback.services;

import com.maxback.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
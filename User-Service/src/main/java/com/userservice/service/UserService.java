package com.userservice.service;

import com.userservice.entity.User;

import java.util.List;

public interface UserService  {
    User saveUser(User user);

    User getUserById(String userId);

    List<User> getAllUser();


    void deleteById(String userId);
}

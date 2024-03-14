package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;


public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findByUsernameContaining(String username) {
        List<User> users = userRepository.findByUsernameContaining(username);
        return users;
    }
    
}

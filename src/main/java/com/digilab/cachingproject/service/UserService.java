package com.digilab.cachingproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.digilab.cachingproject.entity.User;
import com.digilab.cachingproject.repos.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable("user")
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Cacheable("users")
    public  List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User saveUser(User user){

        return userRepository.save(user);

    }
}
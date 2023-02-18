package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(String username, String password){
        User user = new User(username,password);
        userRepository.save(user);
        return user;
    }

    public void deleteUser(int userId) throws Exception {
        if(!userRepository.findById(userId).isPresent()) {
            throw new Exception("User not found");
        }
        userRepository.deleteById(userId);
    }

    public User updateUser(Integer userId, String password) throws Exception {
        if(!userRepository.findById(userId).isPresent()) {
            throw new Exception("User not found");
        }
        User user = userRepository.findById(userId).get();
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }
}

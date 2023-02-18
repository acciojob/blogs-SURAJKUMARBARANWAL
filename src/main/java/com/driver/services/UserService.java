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
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);

    }

    public void deleteUser(int userId) throws Exception{
        User user=userRepository.findById(userId).get();
        if(user==null) throw new Exception("User not found");
        userRepository.deleteById(userId);

    }

    public User updateUser(Integer id, String password) throws Exception{
        User user=userRepository.findById(id).get();
        if(user==null) throw new Exception("User not found");
        user.setPassword(password);
        return userRepository.save(user);
    }
}

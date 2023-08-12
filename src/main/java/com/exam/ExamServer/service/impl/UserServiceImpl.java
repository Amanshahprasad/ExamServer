package com.exam.ExamServer.service.impl;

import com.exam.ExamServer.model.User;
import com.exam.ExamServer.repo.UserRepository;
import com.exam.ExamServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(User user) throws Exception {
          userRepository.saveAndFlush(user);
        return null;
    }

    @Override
    public User getUser(Long userId) throws Exception {
        Optional<User> user= userRepository.findById(userId);
        if(user.get()==null){
            throw new Exception("User is not found");
        }
        return user.get();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

package com.exam.ExamServer.service;

import com.exam.ExamServer.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(User user) throws Exception;
    User getUser(Long userId) throws Exception;

    void deleteUser(Long userId);
}

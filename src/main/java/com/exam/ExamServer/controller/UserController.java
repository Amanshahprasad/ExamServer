package com.exam.ExamServer.controller;

import com.exam.ExamServer.model.User;
import com.exam.ExamServer.repo.UserRepository;
import com.exam.ExamServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {


        return userService.createUser(user);
    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) throws Exception {
        return userService.getUser(userId);
    }

    @GetMapping("/{username}/{password}")
    public User getUser(@PathVariable String username, @PathVariable String password){
        return userRepository.findByUsernameAndPassword(username,password);
    }
    @DeleteMapping("/{userId}")
    public  void deleteUser(@PathVariable Long userId){
         userService.deleteUser(userId);
         return;
    }
}

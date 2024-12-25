package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest.getUser(), userRequest.getPosts());
    }

    @GetMapping("/name/{name}")
    public List<User> findUsersByName(@PathVariable String name) {
        return userService.findUsersByName(name);
    }

    @GetMapping("/domain")
    public List<User> findUsersByEmailDomain(@RequestParam String domain) {
        return userService.findUsersByEmailDomain(domain);
    }

    @GetMapping("/{userId}/posts")
    public List<Post> findPostsByUserId(@PathVariable Long userId) {
        return userService.findPostsByUserId(userId);
    }
}
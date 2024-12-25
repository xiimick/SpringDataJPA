package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.entity.User;

import java.util.List;

public class UserRequest {

    private User user;
    private List<Post> posts;

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
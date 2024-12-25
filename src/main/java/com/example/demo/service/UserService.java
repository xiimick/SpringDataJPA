package com.example.demo.service;

import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public User createUser(User user, List<Post> posts) {
        User savedUser = userRepository.save(user);

        for (Post post : posts) {
            post.setUser(savedUser);
            postRepository.save(post);
        }

        return savedUser;
    }

    public List<User> findUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findUsersByEmailDomain(String domain) {
        return userRepository.findByEmailDomain(domain);
    }

    public List<Post> findPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }
}
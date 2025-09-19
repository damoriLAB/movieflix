package com.javax.movieFlix.service;

import com.javax.movieFlix.entity.User;
import com.javax.movieFlix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) { return userRepository.save(user); }
}

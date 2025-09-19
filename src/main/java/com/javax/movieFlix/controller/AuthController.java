package com.javax.movieFlix.controller;

import com.javax.movieFlix.controller.request.UserRequest;
import com.javax.movieFlix.controller.response.UserResponse;
import com.javax.movieFlix.entity.User;
import com.javax.movieFlix.mapper.UserMapper;
import com.javax.movieFlix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    // TODO: Encode User Password
    @GetMapping
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        User savedUser = userService.save(UserMapper.toUser(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toResponse(savedUser));
    }
}

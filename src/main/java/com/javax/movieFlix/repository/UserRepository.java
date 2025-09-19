package com.javax.movieFlix.repository;

import com.javax.movieFlix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

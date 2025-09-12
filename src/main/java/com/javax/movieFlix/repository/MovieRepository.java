package com.javax.movieFlix.repository;

import com.javax.movieFlix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

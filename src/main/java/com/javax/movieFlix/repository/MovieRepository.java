package com.javax.movieFlix.repository;

import com.javax.movieFlix.entity.Category;
import com.javax.movieFlix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByCategories(List<Category> categories);
}

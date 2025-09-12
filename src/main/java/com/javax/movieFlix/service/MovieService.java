package com.javax.movieFlix.service;

import com.javax.movieFlix.entity.Movie;
import com.javax.movieFlix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> findAll(){ return movieRepository.findAll();  }
    public Movie save(Movie movie){ return movieRepository.save(movie); }
    public Optional<Movie> findByID(Long id){ return movieRepository.findById(id); }
    public void deleteByID(Long id) { movieRepository.deleteById(id);}
}

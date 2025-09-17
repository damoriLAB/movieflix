package com.javax.movieFlix.service;


import com.javax.movieFlix.entity.Category;
import com.javax.movieFlix.entity.Movie;
import com.javax.movieFlix.entity.Streaming;
import com.javax.movieFlix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public List<Movie> findAll(){ return movieRepository.findAll();  }
    public Movie save(Movie movie){
        movie.setCategories(findCategories(movie.getCategories()));
        movie.setStreamings(findStreamings(movie.getStreamings()));
        return movieRepository.save(movie);
    }
    public Optional<Movie> findByID(Long id){ return movieRepository.findById(id); }
    public void deleteByID(Long id) { movieRepository.deleteById(id);}

    public Optional<Movie> update(Long id, Movie movieUptaded){
        Optional<Movie> optMovie = movieRepository.findById(id);

        if(optMovie.isEmpty()) return optMovie;

        List<Category> categories = findCategories(movieUptaded.getCategories());
        List<Streaming> streamings = findStreamings(movieUptaded.getStreamings());


        Movie movie = optMovie.get();

        if(movieUptaded.getTitle() != null) movie.setTitle(movieUptaded.getTitle());
        if(movieUptaded.getDescription() != null) movie.setDescription(movieUptaded.getDescription());
        if(movieUptaded.getReleaseDate() != null) movie.setReleaseDate(movieUptaded.getReleaseDate());
        if(movieUptaded.getRating() != movie.getRating()) movie.setRating(movieUptaded.getRating());

        if(movieUptaded.getCategories() != null){
            movie.getCategories().clear();
            movie.getCategories().addAll(categories);
        }

        if(movieUptaded.getStreamings() != null){
            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);
        }

        return Optional.of(movieRepository.save(movie));
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories
                .forEach(category -> categoryService.findById(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings){
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings
                .forEach(streaming -> streamingService.findByID(streaming.getId()).ifPresent(streamingsFound::add));
        return streamingsFound;
    }

    public List<Movie> findByCategory(Long categoryID){
        return movieRepository.findMovieByCategories(List.of(Category.builder().id(categoryID).build()));
    }
}

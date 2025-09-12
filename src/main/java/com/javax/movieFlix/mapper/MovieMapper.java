package com.javax.movieFlix.mapper;

import com.javax.movieFlix.controller.request.MovieRequest;
import com.javax.movieFlix.controller.response.CategoryResponse;
import com.javax.movieFlix.controller.response.MovieResponse;
import com.javax.movieFlix.controller.response.StreamingResponse;
import com.javax.movieFlix.entity.Category;
import com.javax.movieFlix.entity.Movie;
import com.javax.movieFlix.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest movieRequest){
        List< Category> categories = movieRequest.categories().stream()
                .map(id -> Category.builder().id(id).build())
                .toList();

        List<Streaming> streamings = movieRequest.streamings().stream()
                .map(id -> Streaming.builder().id(id).build())
                .toList();

        return Movie.builder()
                .title(movieRequest.title())
                .description(movieRequest.description())
                .releaseDate(movieRequest.releaseDate())
                .rating(movieRequest.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie){
        List<CategoryResponse> categoryResponses = movie.getCategories().stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        List<StreamingResponse> streamingResponses = movie.getStreamings().stream()
                .map(StreamingMapper::toResponse)
                .toList();

        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categoryResponses)
                .streamings(streamingResponses)
                .build();
    }
}

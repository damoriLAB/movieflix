package com.javax.movieFlix.controller.response;

import com.javax.movieFlix.entity.Category;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse (
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        double rating,
        List<CategoryResponse> categories,
        List<StreamingResponse> streamings 
) {

}

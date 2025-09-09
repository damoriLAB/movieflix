package com.javax.movieFlix.mapper;


import com.javax.movieFlix.controller.request.CategoryRequest;
import com.javax.movieFlix.controller.response.CategoryResponse;
import com.javax.movieFlix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}

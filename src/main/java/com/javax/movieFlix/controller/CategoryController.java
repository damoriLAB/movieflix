package com.javax.movieFlix.controller;

import com.javax.movieFlix.controller.request.CategoryRequest;
import com.javax.movieFlix.controller.response.CategoryResponse;
import com.javax.movieFlix.entity.Category;
import com.javax.movieFlix.mapper.CategoryMapper;
import com.javax.movieFlix.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(
                categories.stream()
                        .map(CategoryMapper::toCategoryResponse)
                        .toList()
        );
    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> createNewCategory(@Valid @RequestBody CategoryRequest body){
        CategoryResponse response = CategoryMapper.toCategoryResponse(
                categoryService.saveCategory(
                        CategoryMapper.toCategory(body)
                ));

        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id){
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryByID(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

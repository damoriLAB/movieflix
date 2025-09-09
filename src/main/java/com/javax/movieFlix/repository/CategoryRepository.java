package com.javax.movieFlix.repository;

import com.javax.movieFlix.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

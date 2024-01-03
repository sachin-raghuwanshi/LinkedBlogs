package com.programmers.blogwebsite.repositories;

import com.programmers.blogwebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}

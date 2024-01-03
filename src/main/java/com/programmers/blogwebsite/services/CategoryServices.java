package com.programmers.blogwebsite.services;

import com.programmers.blogwebsite.entity.Category;
import com.programmers.blogwebsite.payloads.CategoryDto;
import com.programmers.blogwebsite.payloads.UserDto;

import java.util.List;

public interface CategoryServices {
    public CategoryDto createCategory(CategoryDto categoryDto);
    public void deleteCategory(int categoryId);
    public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId);
    public CategoryDto getCategoryById(int categoryId);
    public List<CategoryDto> getAllCategories();
}

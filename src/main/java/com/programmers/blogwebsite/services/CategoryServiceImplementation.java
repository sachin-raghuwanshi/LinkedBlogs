package com.programmers.blogwebsite.services;

import com.programmers.blogwebsite.entity.Category;
import com.programmers.blogwebsite.exceptions.ResourceNotfoundException;
import com.programmers.blogwebsite.payloads.CategoryDto;
import com.programmers.blogwebsite.repositories.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryServiceImplementation implements CategoryServices {
    public CategoryRepo categoryRepo;
    public ModelMapper modelMapper;

    public CategoryServiceImplementation(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = DtotoCategory(categoryDto);
        Category savedCategory = categoryRepo.save(category);
        return CategorytoDto(savedCategory);
    }

    @Override
    public void deleteCategory(int categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotfoundException("Category", "Id", categoryId));
        categoryRepo.delete(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotfoundException("Category", "Id", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category categoryUpdated = categoryRepo.save(category);
        return CategorytoDto(categoryUpdated);

    }

    @Override
    public CategoryDto getCategoryById(int categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotfoundException("Category", "Id", categoryId));
        return CategorytoDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> list = categoryRepo.findAll();
        List<CategoryDto> listDto = new ArrayList<>();
        for (Category category : list) {
            listDto.add(CategorytoDto(category));
        }
        return listDto;
    }

    public Category DtotoCategory(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);

    }

    public CategoryDto CategorytoDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }
}
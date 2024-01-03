package com.programmers.blogwebsite.controllers;

import com.programmers.blogwebsite.payloads.CategoryDto;
import com.programmers.blogwebsite.services.CategoryServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    CategoryServices categoryServices;
    @Autowired
    CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }
    @PostMapping("/")
    ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryServices.createCategory(categoryDto), HttpStatus.CREATED);
    }
    @GetMapping("/")
    ResponseEntity<List<CategoryDto>> getCategory() {
        List<CategoryDto> list = categoryServices.getAllCategories();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{categoryId}")
    ResponseEntity<CategoryDto> getCategoryById(@PathVariable int categoryId) {
        CategoryDto categoryDto = categoryServices.getCategoryById(categoryId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }
    @DeleteMapping("/{categoryId}")
    ResponseEntity<?> deleteCategoryById(@PathVariable int categoryId) {
        categoryServices.deleteCategory(categoryId);
        return new ResponseEntity<>(Map.of("Message", "Category deleted successfully"), HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable int categoryId) {
        return new ResponseEntity<>(categoryServices.updateCategory(categoryDto, categoryId), HttpStatus.CREATED);
    }
}

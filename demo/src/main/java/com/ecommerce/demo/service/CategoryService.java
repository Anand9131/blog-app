package com.ecommerce.demo.service;

import com.ecommerce.demo.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    public CategoryDto saveCategory(CategoryDto categoryDto);

    public  void deleteCategory(Long CategoryId);

    public CategoryDto updateCategory(CategoryDto categoryDto , Long categoryId);


    List<CategoryDto> getAllCategory();
}

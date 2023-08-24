package com.ecommerce.demo.service.Impl;


import com.ecommerce.demo.dto.CategoryDto;
import com.ecommerce.demo.entites.Category;
import com.ecommerce.demo.repository.CategoryRepo;
import com.ecommerce.demo.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepo categoryRepo;

    @Autowired
    public ModelMapper mapper;


    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        Category category1 = categoryRepo.save(category);
        CategoryDto categoryDto1 = mapper.map(category1, CategoryDto.class);
        return categoryDto1;
    }

    @Override
    public void deleteCategory(Long CategoryId) {
        categoryRepo.deleteById(CategoryId);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Optional<Category> categoryRepoById = categoryRepo.findById(categoryId);
        Category category = categoryRepoById.get();

        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());
        category.setImageUrl(categoryDto.getImageUrl());

        Category category1 = categoryRepo.save(category);
        CategoryDto categoryDto1 = mapper.map(category1, CategoryDto.class);
        return categoryDto1;
    }

    @Override
   public List<CategoryDto> getAllCategory() {
        List<Category> categoryList = categoryRepo.findAll();
        List<CategoryDto> categoryDtos = categoryList.stream().map(category -> mapToCategoryDto(category)).collect(Collectors.toList());
       return categoryDtos;
    }

    public CategoryDto mapToCategoryDto(Category category){
        CategoryDto categoryDto = mapper.map(category, CategoryDto.class);
        return categoryDto;

}


}

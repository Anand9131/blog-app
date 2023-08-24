package com.ecommerce.demo.controller;

import com.ecommerce.demo.dto.CategoryDto;
import com.ecommerce.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;



    @GetMapping
    public ResponseEntity<CategoryDto> getCategory(){
        List<CategoryDto> allCategory = categoryService.getAllCategory();
       return new ResponseEntity<>( HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto categoryDto1 = categoryService.saveCategory(categoryDto);
         return new ResponseEntity<>(categoryDto1 ,HttpStatus.OK);

    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Long categoryId){
        CategoryDto categoryDto1 = categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}

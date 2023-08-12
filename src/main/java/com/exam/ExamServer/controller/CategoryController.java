package com.exam.ExamServer.controller;

import com.exam.ExamServer.model.Category;
import com.exam.ExamServer.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @PostMapping("/")
    ResponseEntity<Category> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(this.categoryService.addCategory(category));
    }
    @PutMapping("/")
    ResponseEntity<Category> updateCategory(@RequestBody Category category){
        return ResponseEntity.ok(this.categoryService.addCategory(category));
    }
    @GetMapping("/")
    ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }
    @GetMapping("/{cId}")
    ResponseEntity<Category> getCategories(@PathVariable Long cId){
        return ResponseEntity.ok(this.categoryService.getCategory(cId));
    }
    @DeleteMapping("/{cId}")
    ResponseEntity<?> deleteCategory(@PathVariable Long cId){
        this.categoryService.deleteCategory(cId);
       return ResponseEntity.ok("Category Deleted Successfully");
    }
}

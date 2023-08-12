package com.exam.ExamServer.service;

import com.exam.ExamServer.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Category getCategory(Long cId);
    public List<Category> getCategories();
    public void deleteCategory(Long cId);
}

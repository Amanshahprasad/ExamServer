package com.exam.ExamServer.service.impl;

import com.exam.ExamServer.model.Category;
import com.exam.ExamServer.model.User;
import com.exam.ExamServer.repo.CategoryRepository;
import com.exam.ExamServer.repo.UserRepository;
import com.exam.ExamServer.service.CategoryService;
import com.exam.ExamServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl  implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
              this.categoryRepository.saveAndFlush(category);
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category getCategory(Long cId) {
        return this.categoryRepository.findById(cId).get();
    }

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long cId) {
     this.categoryRepository.deleteById(cId);
    }
}

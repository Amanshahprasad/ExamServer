package com.exam.ExamServer.controller;

import com.exam.ExamServer.model.Category;
import com.exam.ExamServer.model.Quiz;
import com.exam.ExamServer.repo.QuizRepository;
import com.exam.ExamServer.service.impl.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    QuizServiceImpl quizService;
    @Autowired
    QuizRepository quizRepository;

    @PostMapping("/")
    ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }
    @PutMapping("/")
    ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }
    @GetMapping("/")
    ResponseEntity<List<Quiz>> getQuizzes(){

        return ResponseEntity.ok(this.quizService.getQuizzes());
    }
    @GetMapping("/{quizId}")
    ResponseEntity<Quiz> getQuizzes(@PathVariable Long quizId){
        return ResponseEntity.ok(this.quizService.getQuiz(quizId));
    }
    @DeleteMapping("/{quizId}")
    ResponseEntity<?> deleteQuiz(@PathVariable Long quizId){
        this.quizService.deleteQuiz(quizId);
        return ResponseEntity.ok("Quiz Deleted Successfully");
    }
    @GetMapping("/category/{cId}")
    List<Quiz> getQuizOfCategories(@PathVariable Long cId){
        Category category=new Category();
        category.setCId(cId);
        return this.quizRepository.findByCategory(category);
    }
    @GetMapping("/active/{cId}")
    List<Quiz> getActiveQuizOfCategories(@PathVariable Long cId){
        Category category=new Category();
        category.setCId(cId);
        return this.quizRepository.findByCategoryAndActive(category,true);
    }
    @GetMapping("/active/")
    List<Quiz> getActiveQuizzes(){

        return this.quizRepository.findByActive(true);
    }
}

package com.exam.ExamServer.repo;

import com.exam.ExamServer.model.Category;
import com.exam.ExamServer.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
    List<Quiz> findByCategory(Category category);
    List<Quiz> findByActive(Boolean b);
    List<Quiz> findByCategoryAndActive(Category category,Boolean b);
}

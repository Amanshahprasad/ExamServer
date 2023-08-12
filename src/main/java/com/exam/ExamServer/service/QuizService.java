package com.exam.ExamServer.service;


import com.exam.ExamServer.model.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Quiz getQuiz(Long qId);
    public List<Quiz> getQuizzes();
    public void deleteQuiz(Long qId);
}

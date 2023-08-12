package com.exam.ExamServer.service.impl;

import com.exam.ExamServer.model.Quiz;
import com.exam.ExamServer.repo.QuizRepository;
import com.exam.ExamServer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl  implements QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        this.quizRepository.saveAndFlush(quiz);
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuiz(Long qId) {
        return this.quizRepository.findById(qId).get();
    }



    @Override
    public List<Quiz> getQuizzes() {
      List<Quiz> quizzes=this.quizRepository.findAll();
        return quizzes;
    }

    @Override
    public void deleteQuiz(Long qId) {
        this.quizRepository.deleteById(qId);
    }
}

package com.exam.ExamServer.service;

import com.exam.ExamServer.model.Question;
import com.exam.ExamServer.model.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Question getQuestion(Long quesId);
    public List<Question> getQuestionOfQuiz(Long quizId);
    public List<Question> getQuestions();
    public void deleteQuestion(Long quesId);
    public Map<String,Object> evaluatingTheQuiz(List<Question> questions);
}

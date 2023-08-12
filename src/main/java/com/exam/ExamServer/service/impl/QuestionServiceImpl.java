package com.exam.ExamServer.service.impl;

import com.exam.ExamServer.model.Question;
import com.exam.ExamServer.model.Quiz;
import com.exam.ExamServer.repo.QuestionRepository;
import com.exam.ExamServer.repo.QuizRepository;
import com.exam.ExamServer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl  implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question getQuestion(Long quesId) {
        return this.questionRepository.findById(quesId).get();
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        Quiz quiz=this.quizRepository.findById(quizId).get();
        List<Question> questionList=quiz.getQuestions();
        if(questionList.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
            questionList=questionList.subList(0,Integer.parseInt(quiz.getNumberOfQuestions())+1);
        }
        questionList.forEach((q->{q.setAnswer("");}));
        Collections.shuffle(questionList);
        return questionList;
    }



    @Override
    public List<Question> getQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public void deleteQuestion(Long quesId) {
        this.questionRepository.deleteById(quesId);
    }

    @Override
    public Map<String, Object> evaluatingTheQuiz(List<Question> questions) {
        double marksGot=0;
        int attempted=0;
        int correctAnswer=0;

        for(Question q:questions){
            String answer=this.getQuestion(q.getQuesId()).getAnswer();
            if(answer.equals(q.getGivenAnswer())){
                correctAnswer++;
                double max= Double.parseDouble(q.getQuiz().getMaxMarks());
                double singleMarks=((max) /questions.size());
                marksGot+=singleMarks;
            }
            if(q.getGivenAnswer()!=null)attempted++;

        }
        Map<String,Object> map= Map.of("marksGot",marksGot,"attempted",attempted,"correctAnswer",correctAnswer);
        return map;
    }

}

package com.exam.ExamServer.controller;

import com.exam.ExamServer.model.Question;
import com.exam.ExamServer.model.Quiz;
import com.exam.ExamServer.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    QuestionServiceImpl questionService;

    @PostMapping("/")
    ResponseEntity<Question> createQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }
    @PutMapping("/")
    ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }
    @GetMapping("/")
    ResponseEntity<List<Question>> getQuestions(){
        return ResponseEntity.ok(this.questionService.getQuestions());
    }
    @GetMapping("/{quesId}")
    ResponseEntity<Question> getQuestion(@PathVariable Long quesId){
        return ResponseEntity.ok(this.questionService.getQuestion(quesId));
    }
    @GetMapping("/quiz/{quizId}")
    ResponseEntity<List<Question>> getQuestionsOfQuiz(@PathVariable Long quizId){
        return ResponseEntity.ok(this.questionService.getQuestionOfQuiz(quizId));
    }

    @GetMapping("/quiz/all/{qId}")
    public  ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qId") Long qId){
        Quiz quiz=new Quiz();
        quiz.setQuizId(qId);
        List<Question>questionList=this.questionService.getQuestionOfQuiz(qId);
        return ResponseEntity.ok(questionList);
    }
    @DeleteMapping("/{quesId}")
    ResponseEntity<?> deleteQuestion(@PathVariable Long quesId){
        this.questionService.deleteQuestion(quesId);
        return ResponseEntity.ok("Question Deleted Successfully");
    }
    @PostMapping("/eval-quiz")
    ResponseEntity<?> evaluateTheQuiz(@RequestBody List<Question> questions){
        return ResponseEntity.ok(questionService.evaluatingTheQuiz(questions));

    }
}

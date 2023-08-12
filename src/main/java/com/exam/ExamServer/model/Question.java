package com.exam.ExamServer.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long quesId;
    String content;
    String image;
    String option1;
    String option2;
    String option3;
    String option4;

    String answer;
    @Transient
    String givenAnswer;
    @ManyToOne(fetch = FetchType.EAGER)
    Quiz quiz;

}

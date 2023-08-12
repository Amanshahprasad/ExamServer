package com.exam.ExamServer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long quizId;
    String title;
    String description;
    String maxMarks;
    String numberOfQuestions;
    boolean active=false;
    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Question> questions=new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    Category category;

}

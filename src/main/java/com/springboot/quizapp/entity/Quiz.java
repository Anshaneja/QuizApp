package com.springboot.quizapp.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity(name = "Quiz")
public class Quiz {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToMany
    private List<Question> questionList;

    private String name;

    public Quiz() {
        super();
    }

    public Quiz(String name, List<Question> questionList) {
        this.name = name;
        this.questionList = questionList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

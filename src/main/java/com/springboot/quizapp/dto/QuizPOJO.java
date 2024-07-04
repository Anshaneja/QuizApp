package com.springboot.quizapp.dto;

import java.util.List;

public class QuizPOJO {

    public int id;
    public String name;
    public List<QuestionPOJO> questions;

    public QuizPOJO() {
        super();
    }

    public QuizPOJO(int id, String name, List<QuestionPOJO> questions) {
        this.name = name;
        this.questions = questions;
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

    public List<QuestionPOJO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionPOJO> questions) {
        this.questions = questions;
    }
}

package com.springboot.quizapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.quizapp.dao.QuestionsDao;
import com.springboot.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionsDao questionsDao;

    ObjectMapper objectMapper;

    public List<Question> getAllQuestions() {
        return questionsDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionsDao.findByCategory(category);
    }

    public List<Question> getQuestionsByDifficultyLevel(String level) {
        return questionsDao.findByDifficultyLevel(level);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionsDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}

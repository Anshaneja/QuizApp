package com.springboot.quizapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.quizapp.dao.QuestionsDao;
import com.springboot.quizapp.dao.QuizDao;
import com.springboot.quizapp.entity.Question;
import com.springboot.quizapp.entity.Quiz;
import com.springboot.quizapp.dto.QuestionPOJO;
import com.springboot.quizapp.dto.QuizDetailsPOJO;
import com.springboot.quizapp.dto.QuizPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuestionsDao questionsDao;

    @Autowired
    QuizDao quizDao;

    @Autowired
    ObjectMapper objectMapper;

    public List<Question> getAllQuestions() {
        return questionsDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionsDao.findByCategory(category);
    }

    public int createNewQuiz(String name, List<String> categoryList, int noOfQuestions) {
        List<Question> questionsByCategoryList = questionsDao.findByCategoryIn(categoryList);
        Collections.shuffle(questionsByCategoryList);
        if(noOfQuestions > 0){
            questionsByCategoryList = questionsByCategoryList.subList(0, Math.min(noOfQuestions, questionsByCategoryList.size()) - 1);
        }
        Quiz savedQuiz = quizDao.save(new Quiz(name, questionsByCategoryList));
        return savedQuiz.getId();
    }

    public QuizPOJO getQuiz(int id){
        Quiz quiz = quizDao.findById(id);
        List<QuestionPOJO> questionPOJOList = objectMapper.convertValue(quiz.getQuestionList(), new TypeReference<List<QuestionPOJO>>() {});
        return new QuizPOJO(quiz.getId(), quiz.getName(), questionPOJOList);
    }

    public Quiz getQuizWithAnswers(int id){
        return quizDao.findById(id);
    }

    public List<QuizDetailsPOJO> getAllQuiz() {
        return objectMapper.convertValue(quizDao.findAll(), new TypeReference<List<QuizDetailsPOJO>>() {});
    }
}

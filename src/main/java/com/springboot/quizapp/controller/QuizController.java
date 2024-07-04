package com.springboot.quizapp.controller;

import com.springboot.quizapp.entity.Quiz;
import com.springboot.quizapp.dto.QuizDetailsPOJO;
import com.springboot.quizapp.dto.QuizPOJO;
import com.springboot.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/create")
    public int createNewQuiz(@RequestParam List<String> categoryList, @RequestParam String name, @RequestParam int limit){
        return quizService.createNewQuiz(name, categoryList, limit);
    }

    @GetMapping("/{quizId}")
    public QuizPOJO getQuiz(@PathVariable int quizId){
        return quizService.getQuiz(quizId);
    }

    @GetMapping("/answers/{quizId}")
    public Quiz getQuizWithAnswers(@PathVariable int quizId){
        return quizService.getQuizWithAnswers(quizId);
    }

    @GetMapping("/all")
    public List<QuizDetailsPOJO> getAllQuiz(){
        return quizService.getAllQuiz();
    }

}

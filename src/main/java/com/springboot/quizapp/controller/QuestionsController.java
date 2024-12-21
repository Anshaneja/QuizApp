package com.springboot.quizapp.controller;

import com.springboot.quizapp.entity.Question;
import com.springboot.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
@CrossOrigin(origins = {"*"}, exposedHeaders = "Content-Range")
public class QuestionsController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/difficulty/{level}")
    public List<Question> getQuestionsByDifficultyLevel(@PathVariable String level){
        return questionService.getQuestionsByDifficultyLevel(level);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

}

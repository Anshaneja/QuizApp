package com.springboot.quizapp.dao;

import com.springboot.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsDao extends JpaRepository<Question, Integer> {

    public List<Question> findByCategory(String category);
    public List<Question> findByCategoryIn(List<String> categoryList);

    public List<Question> findByDifficultyLevel(String level);

    public List<Question> findByDifficultyLevelIn(List<String> levels);
}

package com.springboot.quizapp.dao;

import com.springboot.quizapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {

    public User findUserByEmail(String email);
}

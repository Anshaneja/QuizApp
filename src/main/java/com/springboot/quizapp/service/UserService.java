package com.springboot.quizapp.service;

import com.springboot.quizapp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.quizapp.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtService jwtService;

    public String authenticateUser(User user) throws Exception {
         String password = userDao.findUserByEmail(user.getEmail()).getPassword();
         if(user.getPassword().equals(password)){
             return jwtService.generateToken(user);
         }
         else throw new Exception("Username and Password does not match: " + user.getEmail());
    }

    public User getUserByEmail(String email){
        return userDao.findUserByEmail(email);
    }

    public int registerUser(User user){
        User registeredUser = userDao.save(user);
        return registeredUser.getId();
    }

}

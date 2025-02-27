package com.springboot.quizapp.entity;

import com.springboot.quizapp.convertor.Encrypt;
import jakarta.persistence.*;

@Table(name = "Users")
@Entity
public class User {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(unique=true)
    private String email;

    @Convert(converter = Encrypt.class)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

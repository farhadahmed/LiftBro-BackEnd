package com.liftbro.backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String first_name;
    private String last_name;
    private Date birthdate;
    private String email;
    private String username;
    private String password;
    private String gender;
    private Timestamp created_at;
    private Timestamp updated_at;
}


/*
SCHEMA

create table users(
	user_id int AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(150) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    birthdate date NOT NULL,
    email VARCHAR(150) NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(150) NOT NULL,
    gender VARCHAR(50),
    created_at timestamp,
    updated_at timestamp,
    unique(username),
    unique(email)
);
 */
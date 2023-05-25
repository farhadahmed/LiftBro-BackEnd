package com.liftbro.backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users_test")
public class UsersTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int users_id;
    private String first_name;
    private String last_name;
}

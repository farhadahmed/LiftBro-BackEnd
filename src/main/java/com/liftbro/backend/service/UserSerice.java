package com.liftbro.backend.service;

import com.liftbro.backend.binding.UsersTest;

import java.util.List;

public interface UserSerice {

    // upsert is a polymorphic method used for both insert and update
    public String upsert(UsersTest user);

    public UsersTest getById(Integer userId);

    public List<UsersTest> getAllUsers();

    public String deleteById(Integer userId);
}

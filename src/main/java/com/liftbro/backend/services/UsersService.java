package com.liftbro.backend.services;

import com.liftbro.backend.models.Users;

import java.util.List;

public interface UsersService {

    // upsert is a polymorphic method used for both insert and update
    public String upsert(Users user);

    public Users getById(Integer userId);

    public List<Users> getAllUsers();

    public String deleteById(Integer userId);
}

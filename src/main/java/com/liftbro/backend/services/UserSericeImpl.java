package com.liftbro.backend.services;

import com.liftbro.backend.models.UsersTest;
import com.liftbro.backend.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSericeImpl implements UsersServiceTODELETE {

    @Autowired
    private UserRepository userRepo;

    @Override
    public String upsert(UsersTest user) {
        userRepo.save(user); // upsert -- either insert or update based on primary key
        return "success";
    }

    @Override
    public UsersTest getById(Integer userId) {
        Optional<UsersTest> findById = userRepo.findById(userId);

        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public List<UsersTest> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public String deleteById(Integer userId) {
        if (userRepo.existsById(userId)) {
            userRepo.deleteById(userId);
            return "Delete successful";
        }
        else {
            return "No record found";
        }
    }
}

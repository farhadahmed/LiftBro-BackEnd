package com.liftbro.backend.services;

import com.liftbro.backend.models.Users;
import com.liftbro.backend.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public String upsert(Users user) {
        usersRepository.save(user); // upsert -- either insert or update based on primary key
        return "success";
    }

    @Override
    public Users getById(Integer userId) {
        Optional<Users> findById = usersRepository.findById(userId);

        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public String deleteById(Integer userId) {
        if (usersRepository.existsById(userId)) {
            usersRepository.deleteById(userId);
            return "Delete successful";
        }
        else {
            return "No record found";
        }
    }
}

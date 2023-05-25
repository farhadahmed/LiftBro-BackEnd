package com.liftbro.backend.repos;

import com.liftbro.backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface UsersRepository extends JpaRepository<Users, Serializable> {
}

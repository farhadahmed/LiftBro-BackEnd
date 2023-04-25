package com.liftbro.backend.repos;

import com.liftbro.backend.models.UsersTest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;

public interface UserRepository extends JpaRepository<UsersTest, Serializable> {
}

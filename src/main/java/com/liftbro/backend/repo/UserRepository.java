package com.liftbro.backend.repo;

import com.liftbro.backend.binding.UsersTest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;

public interface UserRepository extends JpaRepository<UsersTest, Serializable> {
}

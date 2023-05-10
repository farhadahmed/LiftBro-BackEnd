package com.liftbro.backend.repos;

import com.liftbro.backend.models.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;
import java.util.Optional;

public interface PhotosRepository extends JpaRepository<Photos, Integer> {
}

package com.liftbro.backend.repos;

import com.liftbro.backend.models.Demos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface DemosRepository extends JpaRepository<Demos, Serializable> {
}

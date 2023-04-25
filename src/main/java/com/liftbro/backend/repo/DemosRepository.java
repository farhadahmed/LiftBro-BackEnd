package com.liftbro.backend.repo;

import com.liftbro.backend.binding.Demos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface DemosRepository extends JpaRepository<Demos, Serializable> {
}

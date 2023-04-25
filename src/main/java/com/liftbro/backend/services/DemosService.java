package com.liftbro.backend.services;

import com.liftbro.backend.models.Demos;

import java.util.List;

public interface DemosService {
    public String upsert(Demos demo);
    public Demos getById(Integer id);
    public List<Demos> getAllDemos();
    public String deleteById(Integer id);
}

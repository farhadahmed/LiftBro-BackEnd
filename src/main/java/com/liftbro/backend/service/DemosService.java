package com.liftbro.backend.service;

import com.liftbro.backend.binding.Demos;

import java.util.List;

public interface DemosService {
    public String upsert(Demos demo);
    public Demos getById(Integer id);
    public List<Demos> getAllDemos();
    public String deleteById(Integer id);
}

package com.liftbro.backend.service;

import com.liftbro.backend.binding.Demos;
import com.liftbro.backend.repo.DemosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemosServiceImpl implements DemosService{

    @Autowired
    private DemosRepository demosRepo;

    @Override
    public String upsert(Demos demo) {
        demosRepo.save(demo);
        return "success";
    }

    @Override
    public Demos getById(Integer id) {
        Optional<Demos> findById = demosRepo.findById(id);

        if (findById.isPresent()) {
            return findById.get();
        }

        return null;
    }

    @Override
    public List<Demos> getAllDemos() {
        return demosRepo.findAll();
    }

    @Override
    public String deleteById(Integer id) {
        if (demosRepo.existsById(id)) {
            demosRepo.deleteById(id);
            return "delete successful";
        }
        else {
            return "no record found";
        }
    }
}

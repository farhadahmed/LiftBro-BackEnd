package com.liftbro.backend.services;

import com.liftbro.backend.models.Photos;
import java.util.List;

public interface PhotosService {
    public String upsert(Photos photo);
    public Photos getById(Integer id);
    public List<Photos> getAllDemos();
    public String deleteById(Integer id);
}

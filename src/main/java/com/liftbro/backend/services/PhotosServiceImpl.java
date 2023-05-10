package com.liftbro.backend.services;

import com.liftbro.backend.models.Photos;
import com.liftbro.backend.repos.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PhotosServiceImpl implements PhotosService {

    @Autowired
    private PhotosRepository photosRepo;

//    private final String FOLDER_PATH = "/Users/farhadahmed/Developer/LiftBro/ImageFiles/";

//    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
//        String filePath=FOLDER_PATH+file.getOriginalFilename();
//
//        Photos fileData=photosRepo.save(Photos.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .filePath(filePath).build());
//
//        file.transferTo(new File(filePath));
//
//        if (fileData != null) {
//            return "file uploaded successfully : " + filePath;
//        }
//        return null;
//    }

    @Override
    public String upsert(Photos photo) {
        photosRepo.save(photo);
        return "success";
    }

    @Override
    public Photos getById(Integer id) {
        Optional<Photos> findById = photosRepo.findById(id);

        if (findById.isPresent()) {
            return findById.get();
        }

        return null;
    }

    @Override
    public List<Photos> getAllDemos() {
        return photosRepo.findAll();
    }

    @Override
    public String deleteById(Integer id) {
        if (photosRepo.existsById(id)) {
            photosRepo.deleteById(id);
            return "delete successful";
        }
        else {
            return "no record found";
        }
    }
}

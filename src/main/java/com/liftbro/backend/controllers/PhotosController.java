package com.liftbro.backend.controllers;

import com.liftbro.backend.models.Photos;
import com.liftbro.backend.services.PhotosService;
import com.liftbro.backend.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class PhotosController {

    @Autowired
    private PhotosService photosService;

    @Autowired
    private StorageService service;

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = service.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData=service.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }



//    @PostMapping("/photos")
//    public ResponseEntity<String> createPhoto(@RequestBody Photos photo) {
//        String status = photosService.upsert(photo);
//        return new ResponseEntity<>(status, HttpStatus.CREATED);
//    }

//    @GetMapping("/photos/{id}")
//    public ResponseEntity<Photos> getPhoto(@PathVariable Integer id) {
//        Photos photo = photosService.getById(id);
//        return new ResponseEntity<>(photo, HttpStatus.OK);
//    }


    // ONLY to be used for changing the photo_order
//    @PutMapping("/photos/{id}")
//    public ResponseEntity<String> updatePhoto(@RequestBody Photos photo) {
//        String status = photosService.upsert(photo);
//        return new ResponseEntity<>(status, HttpStatus.OK);
//    }

//    @DeleteMapping("/photos/{id}")
//    public ResponseEntity<String> deletePhoto(@PathVariable Integer id) {
//        String status = photosService.deleteById(id);
//        return new ResponseEntity<>(status, HttpStatus.OK);
//    }
}

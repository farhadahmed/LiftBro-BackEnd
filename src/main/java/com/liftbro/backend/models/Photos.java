package com.liftbro.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@Entity
@Table(name = "photos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int photo_id;
    private int user_id;
    private int photo_order;
    private boolean is_profile_photo;

    private String fileName;
    private String fileType;
    private String filePath;
//    private Blob photo;
}

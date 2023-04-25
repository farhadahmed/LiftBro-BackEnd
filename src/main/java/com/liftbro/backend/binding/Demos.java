package com.liftbro.backend.binding;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="demos")
public class Demos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
}

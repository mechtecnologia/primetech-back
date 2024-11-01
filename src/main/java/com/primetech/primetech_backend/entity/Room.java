package com.primetech.primetech_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String capacity;
    private String type;
}

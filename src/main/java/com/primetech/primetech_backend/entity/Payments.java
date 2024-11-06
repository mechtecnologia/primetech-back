package com.primetech.primetech_backend.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "payment_date")
    private LocalDateTime paymentDate;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User userId;



}
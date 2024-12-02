package com.primetech.primetech_backend.controller;

import com.primetech.primetech_backend.entity.Payments;
import com.primetech.primetech_backend.service.PaymentsService;
import com.primetech.primetech_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/payments")
public class PaymentsController {
    @Autowired
    private PaymentsService paymentsService;


    @GetMapping("/list")
    public List<Payments> findAll() {
        return paymentsService.listarUsers();
    }

}

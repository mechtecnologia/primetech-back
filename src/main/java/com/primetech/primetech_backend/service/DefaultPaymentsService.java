package com.primetech.primetech_backend.service;


import com.primetech.primetech_backend.entity.Payments;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class DefaultPaymentsService implements PaymentsService {


    @Autowired
    private PaymentsRepository paymentsRepository;


    @Override
    public Payments save(Payments payments) {
        System.out.println("teste");
        return paymentsRepository.save(payments);
    }

    @Override
    public List<Payments> listarUsers() {
        return paymentsRepository.findAll();
    }
}

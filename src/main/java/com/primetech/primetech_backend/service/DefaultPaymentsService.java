package com.primetech.primetech_backend.service;


import com.primetech.primetech_backend.entity.Payments;
import com.primetech.primetech_backend.entity.Session;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DefaultPaymentsService implements PaymentsService {


    @Autowired
    private PaymentsRepository paymentsRepository;


    @Override
    public Payments save(User user, Session sesion) {
        Payments payments = new Payments();
        payments.setPaymentDate(LocalDateTime.now());
        payments.setUserId(user);
        //colocar no futuro session tbm
        return paymentsRepository.save(payments);
    }

    @Override
    public List<Payments> listarUsers() {
        return paymentsRepository.findAll();
    }
}

package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.entity.Payments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentsService {

    Payments save(Payments payments);

    List<Payments> listarUsers();
}

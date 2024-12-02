package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.entity.Payments;
import com.primetech.primetech_backend.entity.Session;
import com.primetech.primetech_backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentsService {

    Payments save(User user, Session sesion);

    List<Payments> listarUsers();
}

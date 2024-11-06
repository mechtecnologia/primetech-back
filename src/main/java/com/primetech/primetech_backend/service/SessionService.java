package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.dto.SessionDTO;
import com.primetech.primetech_backend.entity.Session;
import org.springframework.stereotype.Service;

@Service
public interface SessionService {

    Session save(SessionDTO sessionDTO);

    Session find(Integer id);

    Session findEspecif(Integer roomID, Integer timeslotID);
}
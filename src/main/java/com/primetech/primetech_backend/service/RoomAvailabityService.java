package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.entity.RoomAvailabity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomAvailabityService {

    List<RoomAvailabity>listarHorarios(Integer idSala);


}

package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.entity.RoomAvailabity;
import com.primetech.primetech_backend.repository.RoomAvailabityRepository;
import com.primetech.primetech_backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DefaultRoomAvailabity implements RoomAvailabityService {
    @Autowired
    private RoomAvailabityRepository roomAvailabityRepository;


    @Override
    public List<RoomAvailabity> listarHorarios(Integer idSala) {

        return roomAvailabityRepository.listarHorarios(idSala);
    }
}

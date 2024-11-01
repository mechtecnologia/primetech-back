package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.entity.Room;
import com.primetech.primetech_backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class DefaultRoomService implements RoomService {


    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> listarSalas() {
        return roomRepository.findAll();
    }
}

package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
    List<Room>listarSalas();

}

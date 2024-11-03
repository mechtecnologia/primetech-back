package com.primetech.primetech_backend.controller;


import com.primetech.primetech_backend.dto.RoomavailabityDTO;
import com.primetech.primetech_backend.entity.Room;
import com.primetech.primetech_backend.entity.RoomAvailabity;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.repository.RoomRepository;
import com.primetech.primetech_backend.service.RoomAvailabityService;
import com.primetech.primetech_backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomAvailabityService roomAvailabityService;

    @GetMapping("/{id}")
    public RoomavailabityDTO findTime(@PathVariable Integer id){
        return roomAvailabityService.listarHorarios(id);
    }

    @GetMapping("/list")
    public List<Room> findAll() {
        return roomService.listarSalas();
    }



}

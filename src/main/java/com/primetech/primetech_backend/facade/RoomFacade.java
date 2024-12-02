package com.primetech.primetech_backend.facade;

import com.primetech.primetech_backend.dto.RoomavailabityDTO;
import com.primetech.primetech_backend.dto.SessionDTO;
import com.primetech.primetech_backend.entity.Room;
import com.primetech.primetech_backend.entity.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoomFacade {

    List<Room> roomList();

    RoomavailabityDTO roomListHour(Integer roomId);

    void createSession(SessionDTO sessionDTO);

    Session findSessionByHour(Integer roomId, Integer timeslotId);


    Session findSessionById(Integer id);
}

package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.dto.SessionDTO;
import com.primetech.primetech_backend.entity.Room;
import com.primetech.primetech_backend.entity.Session;
import com.primetech.primetech_backend.entity.TimeSlot;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultSessionService implements SessionService {

    @Autowired
    private SessionRepository repository;

    @Override
    public Session save(SessionDTO sessionDTO) {
        Session session = convertToSession(sessionDTO);
        return repository.save(session);
    }

    @Override
    public Session find(Integer id){
        return  repository.findById(id).get();
    }

    @Override
    public Session findEspecif(Integer roomID, Integer timeslotID){
        return repository.findEspefic(roomID, timeslotID);
    }


    private Session convertToSession(SessionDTO sessionDTO){
        Session session = new Session();
        session.setDate(sessionDTO.getDate());

        User user = new User();
        user.setId(sessionDTO.getUserManager_id());

        Room room = new Room();
        room.setId(sessionDTO.getRoomId());

        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setId(sessionDTO.getTimeslotId());

        session.setUserId(user);
        session.setRoomId(room);
        session.setTimeSlot_Id(timeSlot);

        return session;

    }
}

package com.primetech.primetech_backend.facade;

import com.primetech.primetech_backend.dto.PaymentsDto;
import com.primetech.primetech_backend.dto.RoomavailabityDTO;
import com.primetech.primetech_backend.dto.SessionDTO;
import com.primetech.primetech_backend.entity.Payments;
import com.primetech.primetech_backend.entity.Room;
import com.primetech.primetech_backend.entity.Session;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class RoomDefaultFacade implements RoomFacade {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomAvailabityService roomAvailabityService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentsService paymentsService;

    @Override
    public List<Room> roomList() {
        return roomService.listarSalas();
    }

    @Override
    public RoomavailabityDTO roomListHour(Integer roomId) {
        return roomAvailabityService.listarHorarios(roomId);
    }

    @Transactional
    @Override
    public void createSession(SessionDTO sessionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userService.findUserByEmail(email);

        Session session = sessionService.save(sessionDTO,user);
        roomAvailabityService.save(sessionDTO.getRoomId(), sessionDTO.getTimeslotId());
        paymentsService.save(user,session);
    }

    @Override
    public Session findSessionByHour(Integer roomId, Integer timeslotId) {
        return sessionService.findEspecif(roomId,timeslotId);
    }

    @Override
    public Session findSessionById(Integer id) {
        return  sessionService.find(id);
    }
}

package com.primetech.primetech_backend.controller;


import com.primetech.primetech_backend.dto.RoomavailabityDTO;
import com.primetech.primetech_backend.dto.SessionDTO;
import com.primetech.primetech_backend.dto.UserResponseDTO;
import com.primetech.primetech_backend.entity.Room;
import com.primetech.primetech_backend.entity.RoomAvailabity;
import com.primetech.primetech_backend.entity.Session;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.repository.RoomRepository;
import com.primetech.primetech_backend.service.RoomAvailabityService;
import com.primetech.primetech_backend.service.RoomService;
import com.primetech.primetech_backend.service.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomAvailabityService roomAvailabityService;

    @Autowired
    private SessionService sessionService;

    @Operation(summary = "horario e disponibilidadede da sala especifica",
            description = "horario e disponibilidadede da sala especifica",
            responses = {
                    @ApiResponse(responseCode = "200", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = RoomavailabityDTO.class))
                    })
            }
    )
    @GetMapping("/avaliable/{id}")
    public RoomavailabityDTO findTime(@PathVariable Integer id){
        return roomAvailabityService.listarHorarios(id);
    }

    @Operation(summary = "listar todas as salas",
            description = "listar todas as salas"
    )
    @GetMapping("/list")
    public List<Room> findAll() {
        roomAvailabityService.save(1,1);
        return roomService.listarSalas();
    }

    @Operation(summary = "Criar nova Sessao",
            description = "Criar nova Sessao"
    )
    @PostMapping("/session")
    public Session saveSession(@RequestBody SessionDTO sessionDTO){

       return sessionService.save(sessionDTO);
    }


    @Operation(summary = "procura session especifica",
            description = "procura session especifica"
    )
    @GetMapping("/by-room-timeslot/{roomId}/{timeslotId}")
    public Session findEspecificTime(@PathVariable Integer roomId, @PathVariable Integer timeslotId ){
        return sessionService.findEspecif(roomId, timeslotId);
    }


    @GetMapping("/session/{id}")
    public Session findSession(@PathVariable Integer id){
        return sessionService.find(id);
    }




}

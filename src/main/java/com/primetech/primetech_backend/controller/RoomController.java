package com.primetech.primetech_backend.controller;


import com.primetech.primetech_backend.dto.RoomavailabityDTO;
import com.primetech.primetech_backend.dto.SessionDTO;
import com.primetech.primetech_backend.dto.UserResponseDTO;
import com.primetech.primetech_backend.entity.Room;
import com.primetech.primetech_backend.entity.RoomAvailabity;
import com.primetech.primetech_backend.entity.Session;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.facade.RoomFacade;
import com.primetech.primetech_backend.repository.RoomRepository;
import com.primetech.primetech_backend.service.PaymentsService;
import com.primetech.primetech_backend.service.RoomAvailabityService;
import com.primetech.primetech_backend.service.RoomService;
import com.primetech.primetech_backend.service.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomFacade roomFacade;


    @Operation(summary = "listar todas as salas",
            description = "listar todas as salas"
    )
    @GetMapping("/list")
    public List<Room> findAll() {
        return roomFacade.roomList();
    }

    @Operation(summary = "horario e disponibilidadede da sala especifica",
            description = "horario e disponibilidadede da sala especifica",
            responses = {
                    @ApiResponse(responseCode = "200", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = RoomavailabityDTO.class))
                    })
            }
    )
    @GetMapping("/avaliable/{roomId}")
    public RoomavailabityDTO findTime(@PathVariable Integer roomId){
        return roomFacade.roomListHour(roomId);
    }


    @Operation(summary = "Criar nova Sessao(reservar sala)",
            description = "Criar nova Sessao"
    )
    @PostMapping("/session")
    public ResponseEntity saveSession(@RequestBody SessionDTO sessionDTO){
        roomFacade.createSession(sessionDTO);
        return ResponseEntity.ok("funcionou");
    }


    @Operation(summary = "procura se ha uma sessao para x sala, em y horario",
            description = "procura session especifica"
    )
    @GetMapping("/find/session/{roomId}/{timeslotId}")
    public Session findEspecificTime(@PathVariable Integer roomId, @PathVariable Integer timeslotId ){
        return roomFacade.findSessionByHour(roomId,timeslotId);
    }


    @Operation(summary = "se necessario ",
            description = "procura session especifica"
    )
    @GetMapping("/session/{id}")
    public Session findSession(@PathVariable Integer id){
        return roomFacade.findSessionById(id);
    }

    private boolean hasRole(Authentication authentication, String roleName) {
        return authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(roleName));
    }


}

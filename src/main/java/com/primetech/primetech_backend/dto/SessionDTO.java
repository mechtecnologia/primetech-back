package com.primetech.primetech_backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.Date;

@Data
public class SessionDTO {


    private Integer roomId;

    private Integer userManager_id;

    private Integer timeslotId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East" )
    private Date date;
}

package com.primetech.primetech_backend.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PaymentsDto {

    private Integer UserId;

    private LocalDateTime date;
}

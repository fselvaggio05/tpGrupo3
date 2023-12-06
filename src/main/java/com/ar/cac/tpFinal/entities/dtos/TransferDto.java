package com.ar.cac.tpFinal.entities.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TransferDto {
    private Long id;

    private Long origin;

    private Long target;

    private LocalDateTime date;

    private BigDecimal amount;
}

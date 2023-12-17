package com.ar.cac.tpfinalgrupo3.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AccountAuditoryDto {
    private Long id;
    private LocalDateTime auditedAt;
    private String alias;
    private BigDecimal amount;
    private Long accountAudited;

}

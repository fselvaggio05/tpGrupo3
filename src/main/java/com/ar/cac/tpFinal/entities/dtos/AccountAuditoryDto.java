package com.ar.cac.tpFinal.entities.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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


    private LocalDateTime auditedAt;
    private String alias;
    private BigDecimal residue; //saldo de la cuenta
    private Long accountAudited;
    private BigDecimal amount_transaction;
    private Long destiny_account;



}

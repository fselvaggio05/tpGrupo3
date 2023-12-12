package com.ar.cac.tpFinal.entities;

import jakarta.persistence.*;
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
@Table(name = "cuenta_auditoria")
@Entity
public class AccountAuditory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "fecha_auditoria")

    private LocalDateTime auditedAt;

    private String alias;

    @Column(name ="saldo")
    private BigDecimal residue; //saldo de la cuenta

    private BigDecimal amount_transaction;

    private Long accountAudited;

    private Long destiny_account;


}

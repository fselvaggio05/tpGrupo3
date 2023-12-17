package com.ar.cac.tpfinalgrupo3.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table (name = "transferencias")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transferencia")
    private Long id;

    private Long origin;

    private Long target;

    private LocalDateTime date;

    private BigDecimal amount;


    /* este dato ya esta incorporado en el origin de la transferencia, asi que es redundante
    @ManyToOne
    private Account creator; */

}
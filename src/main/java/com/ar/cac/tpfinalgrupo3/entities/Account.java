package com.ar.cac.tpfinalgrupo3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table (name = "cuentas")
@AllArgsConstructor
@NoArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cuenta")
    private Long id;

    /* @Column(name = "account_type")
    private AccountType type;*/

    private String cbu;

    private String alias;

    private BigDecimal amount;

    //usuario dueño de la cuenta
    @ManyToOne
    private User owner;

}

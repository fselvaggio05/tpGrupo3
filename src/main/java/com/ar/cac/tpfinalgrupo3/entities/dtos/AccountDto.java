package com.ar.cac.tpfinalgrupo3.entities.dtos;

import com.ar.cac.tpfinalgrupo3.entities.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class AccountDto {

    private Long id;

    //TODO: crear la enumeración de los tipos de cuentas

    //private AccountType type;

    private String cbu;

    private String alias;

    private BigDecimal amount;

}

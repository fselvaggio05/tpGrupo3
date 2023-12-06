package com.ar.cac.tpFinal.mappers;

import com.ar.cac.tpFinal.entities.Account;
import com.ar.cac.tpFinal.entities.dtos.AccountDto;

public class AccountMapper {
    public static AccountDto accountToDto(Account account){
        AccountDto dto = new AccountDto();
        dto.setAlias(account.getAlias());
        dto.setCbu(account.getCbu());
        //dto.setType(account.getType());
        dto.setAmount(account.getAmount());
        dto.setId(account.getId());
        return dto;
    }

    public static Account dtoToAccount(AccountDto dto){
        Account account = new Account();
        account.setAlias(dto.getAlias());
        //account.setType(dto.getType());
        account.setCbu(dto.getCbu());
        account.setAmount(dto.getAmount());
        return account;
    }
}

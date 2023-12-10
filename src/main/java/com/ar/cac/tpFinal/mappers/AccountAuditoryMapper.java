package com.ar.cac.tpFinal.mappers;

import com.ar.cac.tpFinal.entities.AccountAuditory;
import com.ar.cac.tpFinal.entities.UserAuditory;
import com.ar.cac.tpFinal.entities.dtos.AccountAuditoryDto;
import com.ar.cac.tpFinal.entities.dtos.UserAuditoryDto;

public class AccountAuditoryMapper {
    public static AccountAuditoryDto accountAuditoryToDto(AccountAuditory accountAud) {
        AccountAuditoryDto acAudDto = new AccountAuditoryDto();

        acAudDto.setId(accountAud.getId());
        acAudDto.setAlias(accountAud.getAlias());
        acAudDto.setAmount(accountAud.getAmount());
        acAudDto.setAuditedAt(accountAud.getAuditedAt());
        acAudDto.setAccountAudited(accountAud.getAccountAudited());
        return acAudDto;
    }
}
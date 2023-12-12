package com.ar.cac.tpFinal.mappers;

import com.ar.cac.tpFinal.entities.AccountAuditory;
import com.ar.cac.tpFinal.entities.UserAuditory;
import com.ar.cac.tpFinal.entities.dtos.AccountAuditoryDto;
import com.ar.cac.tpFinal.entities.dtos.UserAuditoryDto;

public class AccountAuditoryMapper {
    public static AccountAuditoryDto accountAuditoryToDto(AccountAuditory accountAud) {
        AccountAuditoryDto acAudDto = new AccountAuditoryDto();


        acAudDto.setAlias(accountAud.getAlias());
        acAudDto.setResidue(accountAud.getResidue());
        acAudDto.setAuditedAt(accountAud.getAuditedAt());
        acAudDto.setAccountAudited(accountAud.getAccountAudited());
        acAudDto.setDestiny_account(accountAud.getDestiny_account());
        acAudDto.setAmount_transaction(accountAud.getAmount_transaction());

        return acAudDto;
    }
}
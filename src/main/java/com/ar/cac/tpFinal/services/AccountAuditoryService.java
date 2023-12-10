package com.ar.cac.tpFinal.services;

import com.ar.cac.tpFinal.entities.Account;
import com.ar.cac.tpFinal.entities.AccountAuditory;
import com.ar.cac.tpFinal.entities.User;
import com.ar.cac.tpFinal.entities.UserAuditory;
import com.ar.cac.tpFinal.entities.dtos.AccountAuditoryDto;
import com.ar.cac.tpFinal.entities.dtos.AccountDto;
import com.ar.cac.tpFinal.entities.dtos.UserAuditoryDto;
import com.ar.cac.tpFinal.entities.dtos.UserDto;
import com.ar.cac.tpFinal.mappers.AccountAuditoryMapper;
import com.ar.cac.tpFinal.mappers.UserAuditoryMapper;
import com.ar.cac.tpFinal.repositories.AccountAuditoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountAuditoryService {
@Autowired
    public AccountAuditoryRepository AccountAudRep;
    public void createAccountAuditory(AccountDto dto, Account accountToModify)
    {
        AccountAuditory accountAuditory = new AccountAuditory();

       accountAuditory.setId(dto.getId());
       accountAuditory.setAuditedAt(LocalDateTime.now());

       accountAuditory.setAlias(dto.getAlias());
       accountAuditory.setAmount(dto.getAmount());
       accountAuditory.setAccountAudited(accountToModify.getId());
        AccountAudRep.save(accountAuditory);

    }
    public List<AccountAuditoryDto> getAccounts() {

        List<AccountAuditory> accountsAudits = AccountAudRep.findAll();
        List<AccountAuditoryDto> acAudDtos = new ArrayList<AccountAuditoryDto>();

        for (AccountAuditory ac : accountsAudits) {
            AccountAuditoryDto acAudDto = AccountAuditoryMapper.accountAuditoryToDto(ac);
            acAudDtos.add(acAudDto);

        }

        return acAudDtos;

    }
}




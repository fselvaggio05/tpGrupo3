package com.ar.cac.tpfinalgrupo3.services;

import com.ar.cac.tpfinalgrupo3.entities.Account;
import com.ar.cac.tpfinalgrupo3.entities.AccountAuditory;
import com.ar.cac.tpfinalgrupo3.entities.User;
import com.ar.cac.tpfinalgrupo3.entities.UserAuditory;
import com.ar.cac.tpfinalgrupo3.entities.dtos.AccountAuditoryDto;
import com.ar.cac.tpfinalgrupo3.entities.dtos.AccountDto;
import com.ar.cac.tpfinalgrupo3.entities.dtos.UserAuditoryDto;
import com.ar.cac.tpfinalgrupo3.entities.dtos.UserDto;
import com.ar.cac.tpfinalgrupo3.mappers.AccountAuditoryMapper;
import com.ar.cac.tpfinalgrupo3.mappers.UserAuditoryMapper;
import com.ar.cac.tpfinalgrupo3.repositories.AccountAuditoryRepository;
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

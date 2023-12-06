package com.ar.cac.tpFinal.services;


import com.ar.cac.tpFinal.entities.Account;
import com.ar.cac.tpFinal.entities.dtos.AccountDto;
import com.ar.cac.tpFinal.mappers.AccountMapper;
import com.ar.cac.tpFinal.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;


    public List<AccountDto> getAll() {

        //mapear los datos recibidos (accounts) a dtoAccounts
        List<Account> accounts = repository.findAll();
        List<AccountDto> acDtos = new ArrayList<AccountDto>();

        for(Account ac : accounts)
        {
            AccountDto a = AccountMapper.accountToDto(ac);
            acDtos.add(a);
        }

        return acDtos;



    }

    public AccountDto getById(Long id) {
        Account ac = repository.findById(id).get();
        return AccountMapper.accountToDto(ac);
    }



    //TODO revisar este metodo que no funciona como deberia, esta creando un account nueva en lugarde actualizr la del id
    public AccountDto updateAccountComplete(Long id, AccountDto dto) {

        if(repository.existsById(id))
        {
            Account acUpdated = repository.findById(id).get();
            Account acModify = repository.save(acUpdated);

            return AccountMapper.accountToDto(acModify);

        }

        return null;

    }

    public AccountDto createAccount(AccountDto acDto) {

        acDto.setAmount(BigDecimal.ZERO);
        Account ac = AccountMapper.dtoToAccount(acDto);
        Account acSaved = repository.save(ac);
        return AccountMapper.accountToDto(acSaved);

    }

    public String deleteAccount(Long id) {

        if(repository.existsById(id))
        {
            repository.deleteById(id);
            return "La cuenta " +id+ " ha sido eliminada";
        }

        else {
            return "La cuenta " +id+ " no ha sido eliminada";
        }
    }
}

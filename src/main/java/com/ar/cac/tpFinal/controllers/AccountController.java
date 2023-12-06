package com.ar.cac.tpFinal.controllers;

import com.ar.cac.tpFinal.entities.Account;
import com.ar.cac.tpFinal.entities.dtos.AccountDto;
import com.ar.cac.tpFinal.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

   @GetMapping(value = "/{id}")
   public ResponseEntity<AccountDto> getById(@PathVariable Long id)
   {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
   }

   @PostMapping
   public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto acDto)
   {
       return ResponseEntity.status(HttpStatus.CREATED).body(service.createAccount(acDto));

   }

   @PutMapping(value="/{id}")
   public ResponseEntity<AccountDto> updateAccountComplete(@PathVariable Long id, @RequestBody AccountDto ac)
   {
       return ResponseEntity.status(HttpStatus.OK).body(service.updateAccountComplete(id,ac));
   }

    //@PatchMapping(value="/{id}")

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteAccount(id));
    }





}

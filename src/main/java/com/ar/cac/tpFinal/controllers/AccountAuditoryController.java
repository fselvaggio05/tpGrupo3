package com.ar.cac.tpFinal.controllers;

import com.ar.cac.tpFinal.entities.dtos.AccountAuditoryDto;
import com.ar.cac.tpFinal.services.AccountAuditoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/accountAuditory")
public class AccountAuditoryController {
    @Autowired
    private AccountAuditoryService accountAudServ;

    @GetMapping
    public ResponseEntity<List<AccountAuditoryDto>> getAccounts() {
        return ResponseEntity.status(HttpStatus.OK).body(accountAudServ.getAccounts());
    }
}
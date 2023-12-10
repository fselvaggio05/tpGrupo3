package com.ar.cac.tpFinal.controllers;

import com.ar.cac.tpFinal.entities.dtos.UserAuditoryDto;
import com.ar.cac.tpFinal.entities.dtos.UserDto;
import com.ar.cac.tpFinal.services.UserAuditoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/userAuditory")
public class UserAuditoryController {

    @Autowired
    private UserAuditoryService userAudServ;


    @GetMapping
    public ResponseEntity<List<UserAuditoryDto>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(userAudServ.getAll());
    }

    /*@GetMapping(value="{/id}")
    public ResponseEntity<List<UserAuditoryDto>> getById(Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userAudServ.getById(id));
    }*/

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<UserAuditoryDto>> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userAudServ.getUserAuditoryById(id));
    }
}

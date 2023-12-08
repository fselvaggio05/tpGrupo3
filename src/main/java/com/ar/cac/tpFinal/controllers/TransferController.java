package com.ar.cac.tpFinal.controllers;

import com.ar.cac.tpFinal.entities.dtos.TransferDto;
import com.ar.cac.tpFinal.services.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService service;

    //donde se realiza el new del objeto TransferService?
    public TransferController(TransferService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TransferDto>> getTransfers(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getTransfers());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<TransferDto> getTransferById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getTransferById(id));
    }


    @PostMapping
    public ResponseEntity<TransferDto> performTransfer(@RequestBody TransferDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTransfer(dto));
    }

    /*
    DELETE Y UPDATE SE OMITEN, YA QUE LAS TRANSFERENCIAS SOLO PODRAN SER CREADAS O CONSULTADAS.

    @PutMapping(value = "/{id}")
    public ResponseEntity<TransferDto> updateTransfer(@PathVariable Long id, @RequestBody TransferDto transfer){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateTransfer(id, transfer));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTransfer(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteTransfer(id));
    }
    */

}

package com.ar.cac.tpFinal.mappers;

import com.ar.cac.tpFinal.entities.Transfer;
import com.ar.cac.tpFinal.entities.dtos.TransferDto;
import lombok.experimental.UtilityClass;



@UtilityClass
public class TransferMapper {

    public Transfer dtoToTransfer(TransferDto dto){
        return Transfer.builder()
                .amount(dto.getAmount())
                .date(dto.getDate())
                .origin(dto.getOrigin())
                .target(dto.getTarget())
                .build();


    }

    public TransferDto transferToDto(Transfer transfer){
        return TransferDto.builder()
                .id(transfer.getId())
                .amount(transfer.getAmount())
                .target(transfer.getTarget())
                .origin(transfer.getOrigin())
                .date(transfer.getDate())
                .build();


    }
}

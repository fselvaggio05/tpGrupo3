package com.ar.cac.tpFinal.services;


import com.ar.cac.tpFinal.mappers.TransferMapper;
import com.ar.cac.tpFinal.entities.Account;
import com.ar.cac.tpFinal.entities.Transfer;
import com.ar.cac.tpFinal.entities.dtos.TransferDto;
import com.ar.cac.tpFinal.repositories.AccountRepository;
import com.ar.cac.tpFinal.repositories.TransferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferService {

    private final TransferRepository repository;

    //esta dependencia se agrega para pedir los datos de las cuentas a la capa del repo de las mismas
    private final AccountRepository accountRepository;

    public TransferService(TransferRepository repository, AccountRepository accountRepository){
        this.repository = repository;
        this.accountRepository = accountRepository;
    }

    public List<TransferDto> getTransfers(){
        List<Transfer> transfers = repository.findAll();
        List<TransferDto> dtos = new ArrayList<TransferDto>();
        for(Transfer tr : transfers)
        {

            dtos.add(TransferMapper.transferToDto(tr));
        }

        return dtos;

        /*return transfers.stream()
                .map(TransferMapper::transferToDto)
                .collect(Collectors.toList()); PREGUNTAR POR COMO FUNCIONARIA ESTO, NO LO ENTIENDO*/
    }


    public TransferDto getTransferById(Long id){
        Transfer transfer = repository.findById(id).get();
        return TransferMapper.transferToDto(transfer); //accedo a los metodos de la clase transfer sin designar static los metodos por la anotacion @Utilityclass

    }

    @Transactional
    public TransferDto createTransfer(TransferDto dto) {


        // Comprobar si las cuentas de origen y destino existen
        //la entidad transfer tiene el id de la cuenta origne y del destino
        Account ac1 = accountRepository.findById(dto.getOrigin()).get();
        Account ac2 = accountRepository.findById(dto.getTarget()).get();


        if((ac1!= null) && (ac2 !=null))
        {
            //me voy a traer cada una de las cuentas para preguntarles los saldos
            //quiero consultar si la cuenta origen tiene los fondos para realizar la transferencia


            if(ac1.getAmount().compareTo(dto.getAmount())>=0) //compatoTo devuelve valor negativo si el seg
            {

                //si la cuenta origen dispone de saldo, entonces se hacen la sustraccion y adicion de dinero

                ac1.setAmount(ac1.getAmount().subtract(dto.getAmount()));
                ac2.setAmount(ac2.getAmount().add(dto.getAmount()));
                accountRepository.save(ac1);
                accountRepository.save(ac2);

                //ahora si, crear la transferencia
                Transfer transfer = new Transfer();
                transfer.setAmount(dto.getAmount());
                transfer.setDate(LocalDateTime.now());
                transfer.setTarget(dto.getTarget());
                transfer.setOrigin(dto.getOrigin());

                repository.save(transfer);


                //devolver el TransferDto

                return TransferMapper.transferToDto(transfer);
            }

            else
            {
                //enviar mensaje de que la cuenta origen no dispone los fondos necesarios
            }
        }
        return null;
    }




/* los comandos update y delete se omiten, ya que las transferencias solo seran consultadas o creadas.


    public TransferDto updateTransfer(Long id, TransferDto transferDto){
        Transfer transfer = repository.findById(id).get();
        Transfer updatedTransfer = TransferMapper.dtoToTransfer(transferDto);
        updatedTransfer.setId(transfer.getId());
        return TransferMapper.transferToDto(repository.save(updatedTransfer));
    }


    public String deleteTransfer(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "Se ha eliminado la transferencia: "+id;
        } else {
            return "No se ha eliminado la transferencia: " +id;
        }
    }
*/





}

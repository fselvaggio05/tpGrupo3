package com.ar.cac.tpfinalgrupo3.services;

import com.ar.cac.tpfinalgrupo3.entities.Operation;
import com.ar.cac.tpfinalgrupo3.entities.User;
import com.ar.cac.tpfinalgrupo3.entities.UserAuditory;
import com.ar.cac.tpfinalgrupo3.entities.dtos.UserAuditoryDto;
import com.ar.cac.tpfinalgrupo3.entities.dtos.UserDto;
import com.ar.cac.tpfinalgrupo3.mappers.TransferMapper;
import com.ar.cac.tpfinalgrupo3.mappers.UserAuditoryMapper;
import com.ar.cac.tpfinalgrupo3.mappers.UserMapper;
import com.ar.cac.tpfinalgrupo3.repositories.UserAuditoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserAuditoryService
{
    @Autowired
    private UserAuditoryRepository userAudRep;



    public void createUserAuditory(UserDto dto, User userToModify)
    {
        UserAuditory userAuditory = new UserAuditory();

        userAuditory.setAuditoryEmail(dto.getEmail());
        userAuditory.setAuditoryPassword(dto.getPass());
        userAuditory.setAuditoryAddress(dto.getAddress());
        userAuditory.setAuditedAt(LocalDateTime.now());
        userAuditory.setUserAud(userToModify);
        userAuditory.setOperation(Operation.CREATED);
        userAudRep.save(userAuditory);

    }




    public void updateUserAuditory(UserDto dto, User userToModify)
    {
        UserAuditory userAuditory = new UserAuditory();

        userAuditory.setAuditoryEmail(dto.getEmail());
        userAuditory.setAuditoryPassword(dto.getPass());
        userAuditory.setAuditoryAddress(dto.getAddress());
        userAuditory.setAuditedAt(LocalDateTime.now());
        userAuditory.setUserAud(userToModify);
        userAuditory.setOperation(Operation.UPDATED);
        userAudRep.save(userAuditory);

    }

    public List<UserAuditoryDto> getAll() {

        List<UserAuditory> usersAudits = userAudRep.findAll();
        List<UserAuditoryDto> usAudDtos = new ArrayList<UserAuditoryDto>();

        for (UserAuditory us : usersAudits) {
            UserAuditoryDto usAudDto = UserAuditoryMapper.userAuditoryToDto(us);
            usAudDtos.add(usAudDto);

        }

        return usAudDtos;

    }

    public List<UserAuditoryDto> getUserAuditoryById(Long id) {

        List<UserAuditory> usAuds = userAudRep.findByUserAudId(id);
        List<UserAuditoryDto> usDtos = new ArrayList<UserAuditoryDto>();

        for (UserAuditory usAud : usAuds)
        {

            usDtos.add(UserAuditoryMapper.userAuditoryToDto(usAud));
        }
        return usDtos;
    }





}

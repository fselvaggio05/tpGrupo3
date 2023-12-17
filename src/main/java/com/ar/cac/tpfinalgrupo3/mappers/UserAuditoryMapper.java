package com.ar.cac.tpfinalgrupo3.mappers;

import com.ar.cac.tpfinalgrupo3.entities.UserAuditory;
import com.ar.cac.tpfinalgrupo3.entities.dtos.UserAuditoryDto;

public class UserAuditoryMapper {

    public static UserAuditoryDto userAuditoryToDto(UserAuditory userAud) {
        UserAuditoryDto usAudDto = new UserAuditoryDto();
        usAudDto.setId(userAud.getId());
        usAudDto.setAuditoryPassword(userAud.getAuditoryPassword());
        usAudDto.setAuditoryEmail(userAud.getAuditoryEmail());
        usAudDto.setAuditoryAddress(userAud.getAuditoryAddress());
        usAudDto.setAuditedAt(userAud.getAuditedAt());
        usAudDto.setUsuarioActualizado(userAud.getUserAud().getId());
        //cuando recupero el registro, recupero el usuario de la relacion y a ese
        //usuario, le pido el id para setearselo al dto.

        usAudDto.setOperacion(userAud.getOperation().toString());

        return usAudDto;
    }

   /* public static UserAuditory dtoToUserAuditory(UserAuditoryDto dto)
    {
        UserAuditory usAd = new UserAuditory();
        usAd.set
    }*/


}

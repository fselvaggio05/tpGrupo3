package com.ar.cac.tpFinal.mappers;

import com.ar.cac.tpFinal.entities.UserAuditory;
import com.ar.cac.tpFinal.entities.dtos.UserAuditoryDto;

public class UserAuditoryMapper {

    public static UserAuditoryDto userAuditoryToDto(UserAuditory userAud) {
        UserAuditoryDto usAudDto = new UserAuditoryDto();
        usAudDto.setId(userAud.getId());
        usAudDto.setAuditoryPassword(userAud.getAuditoryPassword());
        usAudDto.setAuditoryEmail(userAud.getAuditoryEmail());
        usAudDto.setAuditoryAddress(userAud.getAuditoryAddress());
        usAudDto.setAuditedAt(userAud.getAuditedAt());
        usAudDto.setUsuarioActualizado(userAud.getUsuarioActualizado());
        return usAudDto;
    }

   /* public static UserAuditory dtoToUserAuditory(UserAuditoryDto dto)
    {
        UserAuditory usAd = new UserAuditory();
        usAd.set
    }*/


}

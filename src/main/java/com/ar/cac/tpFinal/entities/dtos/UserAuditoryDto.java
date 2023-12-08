package com.ar.cac.tpFinal.entities.dtos;

import com.ar.cac.tpFinal.entities.User;
import com.ar.cac.tpFinal.entities.UserAuditory;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAuditoryDto {

    private Long id;
    private LocalDateTime auditedAt;
    private String auditoryPassword;
    private String auditoryEmail;
    private String auditoryAddress;
    private Long usuarioActualizado;

}

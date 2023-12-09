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
    private String operacion;
    //cambio realizado 8/12 22:30. volvi a crear la relacion con onetomany y viceversa
    //entre user y userAuditory, para respetar el modelo de dominio y la relacion que hicimos
    //y deje este campo del tipo Long, que va a ser el dato a mostrar.

}

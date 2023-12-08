package com.ar.cac.tpFinal.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario_auditoria")
@Entity

public class UserAuditory {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "fecha_auditoria")
        private LocalDateTime auditedAt;

        @Column(name = "Auditoria_contrasenia")
        private String auditoryPassword;

        @Column(name = "Auditoria_email")
        private String auditoryEmail;

        @Column(name = "Auditoria_direccion")
        private String auditoryAddress;

        @ManyToOne
        private User userAud;


}

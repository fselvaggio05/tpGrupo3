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
@Table(name = "usuarioAuditoria")
@Entity

public class UserAuditory {


   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
    private String ModifiedValue;

    @ManyToOne
    private User userAud;*/

   /* @ManyToOne
    private Account accountAud;*/




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private LocalDateTime createdAt;

        @Column(name = "Audit_contrasenia")
        private String auditoryPassword;

        @Column(name = "Audit_email")
        private String auditoryEmail;

        @Column(name = "Auditoria_direccion")
        private String auditoryAddress;

        @ManyToOne
        private User userAud;


}

package com.ar.cac.tpFinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table (name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name= "usuario")
    private String username;

    @Column(name="contrasena")
    private String pass;

    @Column(name="dni")
    private Long dni;

    @Column(name="mail")
    private String email;

    @Column (name ="direccion")
    private String address;

    @Column (name ="fecha_cumpleanios")
    private Date brithdate;

   /* //Fecha de creacion y modificacion del usuario para mantener el estado
    private LocalDateTime created_at;
    */


    private LocalDateTime updated_at;

    //lista de cuentas que tiene el usuario
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;


    @OneToMany(mappedBy = "userAud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAuditory> user;





}


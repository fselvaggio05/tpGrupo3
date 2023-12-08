package com.ar.cac.tpFinal.controllers;



import com.ar.cac.tpFinal.entities.User;
import com.ar.cac.tpFinal.entities.dtos.UserDto;
import com.ar.cac.tpFinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    // POR CADA ACCIÓN/METODO HTTP QUE USTEDES QUIERAN IMPLEMENTAR/PERMITIR
    // VAN A TENER UN METODO EN SU CONTROLADOR

    //METODOS HTTP
    //GET ALL, GET ONE, POST (Para crear), PUT(par update all), PATCH (para update anything), DELETE

    //creo una variable unica para instanciar al UserService y la uso en el contructor de la clase UserController
    @Autowired
    public UserService service;


    /*//aca le paso como parametro esta variable final unica que es la inyeccion de dependencias para que dentro del contructor se inicialice esta variable
    public UserController(UserService service) {
        this.service = service;
    }*/

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUsers());

    }


    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));
    }


   @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user)
    {

      return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));
    }



    //modificar TO-DOS los datos del usuario
   @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> updateUserComplete(@PathVariable Long id, @RequestBody UserDto user) //le paso el id y los datos que quiero actualizar del usuario
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUserComplete(id,user));
    }


    //modificar ALGUNOS datos del usuario
  /*  @PatchMapping(value="/{id}")
    public ResponseEntity<UserDto> updateUserParcial(@PathVariable Long id, @RequestBody UserDto user)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUserPacial(id,user));
    }*/


    /*@DeleteMapping(value="{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }
*/



}

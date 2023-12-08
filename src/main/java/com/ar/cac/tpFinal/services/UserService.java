package com.ar.cac.tpFinal.services;



import com.ar.cac.tpFinal.entities.User;

import com.ar.cac.tpFinal.entities.UserAuditory;
import com.ar.cac.tpFinal.entities.dtos.UserDto;
import com.ar.cac.tpFinal.mappers.UserMapper;
import com.ar.cac.tpFinal.repositories.UserAuditoryRepository;
import com.ar.cac.tpFinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    private UserRepository userRep;

   /* comentado 7/12 22:17
   @Autowired
    private UserAuditoryRepository userAdRep;
*/

    @Autowired
    private UserAuditoryService userAudService;

    @Autowired
    private AccountService accountService;





    //esto esta comentado porque me parece que deberia intervenir primero el mapper
    //y con esos datos transformados, enviarlos al repository


    public List<UserDto> getUsers() {

        //hago la peticion de la coleccion de usuarios a la capa repository que me devuelve entidades users en este caso
        List<User> users = userRep.findAll();

        //ahora debo mapear cada entidad usuario a DTO para devolverla al controlador
        List<UserDto> dtos = new ArrayList<UserDto>();
        for (User us : users) {
            UserDto usDto = UserMapper.userToDto(us);
            dtos.add(usDto);
        }

        return dtos;
    }


    public UserDto getUserById(Long id) {

        User us = userRep.findById(id).get();
        return UserMapper.userToDto(us);
    }


    public UserDto createUser(UserDto userDto) //aca recibo un dto que tengo que transformar a user
    {

        User us = UserMapper.dtoToUser(userDto);
        User usSaved = userRep.save(us); //le pido queme lo devuelva para transformarlo en dto
        userDto = UserMapper.userToDto(usSaved);
        userDto.setPass("*******"); //cuando devuelvo el objeto creado, lo muestro la contraseña y mando estrellitas

        userAudService.createAuditory(userDto, usSaved);

        return userDto;


    }


    //metodo para modificar los datos en forma TOTAL de un usuario
    public UserDto updateUserComplete(Long id, UserDto dto) {

        Long id_User_aud;

      /*  if(userRep.existsById(id))
        {
            //transformo el dto recibido a user
            User us = UserMapper.dtoToUser(dto);
            User userUpdated = userRep.save(us);
            dto = UserMapper.userToDto(userUpdated);


            return dto;

        }

        return null;*/


        if (userRep.existsById(id)) {
            User userToModify = userRep.findById(id).get();



            // Logica del Patch


            if (dto.getEmail() != null) {
                userToModify.setEmail(dto.getEmail());

            }

            if (dto.getPass() != null) {
                userToModify.setPass(dto.getPass());

            }


            if (dto.getAddress() != null) {
                userToModify.setAddress(dto.getAddress());

            }


            userToModify.setUpdated_at(LocalDateTime.now());
            User userModified = userRep.save(userToModify);

            userAudService.createAuditory(dto, userToModify);

            return UserMapper.userToDto(userModified);
        }


        return null;
    }
}






/*
    //metodo para modificar los datos en forma PARCIAL de un usuario
    public UserDto updateUserPacial(Long id, UserDto userDto) {
        //recupero el usuario que se va a modificar de la base de datos
        User userToModify = userRep.findById(id).get();



        userAudService.createAuditory(userDto,userToModify);




        if (userToModify != null)
        {
            //ahora, debo validar cada uno de los campos para saber si vino vacio o no, en caso de que no, realizo el cambio
            //asi evito pisar datos que pueden tener valores si hago un pasaje de dto a user
            if(user.getUsername()!=null)
            {
                userToModify.setUsername(user.getUsername());
                usAd.setModifiedValue(user.getUsername());
            }

            if(user.getDni()!=null)
            {
                userToModify.setDni(user.getDni());
                usAd.setModifiedValue(user.getDni().toString());
            }

            if(user.getEmail()!=null)
            {
                userToModify.setEmail(user.getEmail());
                usAd.setModifiedValue(user.getEmail());
            }

            if(user.getPass()!=null)
            {
                userToModify.setPass(user.getPass());
                usAd.setModifiedValue(user.getPass());
            }


            if(user.getAddress()!=null)
            {
                userToModify.setAddress(user.getAddress());
                usAd.setModifiedValue(user.getAddress());
            }

            if(user.getBrithdate()!=null)
            {
                userToModify.setBrithdate(user.getBrithdate());
                usAd.setModifiedValue(user.getBrithdate().toString());
            }




            return UserMapper.userToDto(userToModify);

        }


        usAd.setUpdated_at(LocalDateTime.now());
        usAd.setUserAud(userToModify);
        userAdRep.save(usAd);
        userRep.save(userToModify);


        return null;*/



/*

    public String deleteUser(long id) {
        */
/*User us= userRep.findById(id).get();
        userRep.delete(us);    esta forma la hice yo*//*


        if (userRep.existsById(id)) {

            userRep.deleteById(id);
            return "El usuario " + id + "ha sido eliminado";
        } else {
            return "El usuario" + id + "no ha sio eliminado";
        }

    }
*/





package com.ar.cac.tpFinal.mappers;

import com.ar.cac.tpFinal.entities.User;
import com.ar.cac.tpFinal.entities.dtos.UserDto;

import java.time.LocalDateTime;

public class UserMapper {


    //declaro los metodos como static (de clase), para que sean accesibles sin crear instancias de la calse
    public static User dtoToUser(UserDto dto)
    {
        User usuario = new User();
        usuario.setUsername(dto.getUsername());
        usuario.setPass(dto.getPass());
        usuario.setBrithdate(dto.getBrithdate());
        usuario.setDni(dto.getDni());
        usuario.setAddress(dto.getAddress());
        usuario.setEmail(dto.getEmail());
        /*usuario.setCreated_at(LocalDateTime.now());
        usuario.setUpdated_at(LocalDateTime.now());*/

        return usuario;

    }


    public static UserDto userToDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPass(user.getPass());
        userDto.setBrithdate(user.getBrithdate());
        userDto.setDni(user.getDni());
        userDto.setAddress(user.getAddress());
        userDto.setEmail(user.getEmail());
       /* userDto.setCreated_at(user.getCreated_at());
        userDto.setUpdated_at(user.getUpdated_at());*/
        return userDto;



    }
}

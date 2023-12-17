package com.ar.cac.tpfinalgrupo3.repositories;


import com.ar.cac.tpfinalgrupo3.entities.User;
import com.ar.cac.tpfinalgrupo3.entities.UserAuditory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //  User findByEmail(String mail);

    List<User> findAll();

    Optional<User> findById(Long id);


}

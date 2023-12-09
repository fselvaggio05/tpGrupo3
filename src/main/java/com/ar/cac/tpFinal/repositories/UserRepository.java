package com.ar.cac.tpFinal.repositories;



import com.ar.cac.tpFinal.entities.User;
import com.ar.cac.tpFinal.entities.UserAuditory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>, UserCriteria<UserAuditory> {

  //  User findByEmail(String mail);

    List<User> findAll();

    Optional<User> findById(Long id);


}

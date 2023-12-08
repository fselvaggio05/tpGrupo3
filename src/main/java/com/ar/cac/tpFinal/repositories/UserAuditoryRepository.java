package com.ar.cac.tpFinal.repositories;


import com.ar.cac.tpFinal.entities.UserAuditory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuditoryRepository extends JpaRepository<UserAuditory, Long> {


}

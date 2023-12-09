package com.ar.cac.tpFinal.repositories;


import com.ar.cac.tpFinal.entities.UserAuditory;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAuditoryRepository extends JpaRepository<UserAuditory, Long>, UserCriteriaFindById <UserAuditory> {




}

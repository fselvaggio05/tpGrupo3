package com.ar.cac.tpFinal.repositories;

import com.ar.cac.tpFinal.entities.UserAuditory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
class UserCriteria implements UserAuditoryRepository {


    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserAuditory> findByIdUserAuditory(Long id) {
        return Optional.empty();
    }
}

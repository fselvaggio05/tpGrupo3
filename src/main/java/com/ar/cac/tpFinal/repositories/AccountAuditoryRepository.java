package com.ar.cac.tpFinal.repositories;

import com.ar.cac.tpFinal.entities.AccountAuditory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAuditoryRepository extends JpaRepository<AccountAuditory, Long> {
}

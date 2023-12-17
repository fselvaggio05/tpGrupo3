package com.ar.cac.tpfinalgrupo3.repositories;

import com.ar.cac.tpfinalgrupo3.entities.AccountAuditory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAuditoryRepository extends JpaRepository<AccountAuditory, Long> {
}

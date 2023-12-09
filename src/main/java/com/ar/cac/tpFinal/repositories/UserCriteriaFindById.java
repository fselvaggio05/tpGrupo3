package com.ar.cac.tpFinal.repositories;

import java.util.List;

public interface UserCriteriaFindById <UserAuditory> {
    List<UserAuditory> findByIdUserAuditory(Long id);

}

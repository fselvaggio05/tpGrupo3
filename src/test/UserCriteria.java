package com.ar.cac.tpFinal.repositories;

import com.ar.cac.tpFinal.entities.User;
import com.ar.cac.tpFinal.entities.UserAuditory;
import com.jayway.jsonpath.Criteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public class UserCriteria implements UserCriteriaFindById {


    @Override
    public List<UserAuditory> findByIdUserAuditory(Long id) {

       /* EntityManager em;
        Optional<UserAuditory> query = em.createQuery("select usAud from UserAuditory usAud where usAud.user_aud_id=?1", UserAuditory.class);
        UserAuditory us = query.s
    }

}*/
        return null;
    }
}
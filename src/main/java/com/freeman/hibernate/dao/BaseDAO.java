package com.freeman.hibernate.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class BaseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Session getCurrentSession (){
        return entityManager.unwrap(Session.class);
    }
}

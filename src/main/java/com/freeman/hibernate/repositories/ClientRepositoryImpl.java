package com.freeman.hibernate.repositories;

import com.freeman.hibernate.entities.Client;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public Client findClientById(Long id) {
        Client client = getCurrentSession().find(Client.class, id);
        return client;
    }

    @Override
    public List<Client> findClientByName(String name) {
        Criteria criteria = getCurrentSession().createCriteria(Client.class);
        criteria.add(Restrictions.like("firstName", name));
        return criteria.list();
    }

    @Override
    public List<Client> getAllClient() {
        Criteria criteria = getCurrentSession().createCriteria(Client.class);
        return criteria.list();
    }

    @Override
    public void saveClient(Client client) {
        getCurrentSession().beginTransaction();
        getCurrentSession().persist(client);
        getCurrentSession().getTransaction().commit();
    }

    @Override
    public Client removeClient(Long id) {
        Transaction transaction = getCurrentSession().getTransaction();
        transaction.begin();
        Client client = getCurrentSession().find(Client.class, id);
        getCurrentSession().remove(client);
        transaction.commit();
        return client;
    }
}

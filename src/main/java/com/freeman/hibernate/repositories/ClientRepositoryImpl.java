package com.freeman.hibernate.repositories;

import com.freeman.hibernate.dao.BaseDAO;
import com.freeman.hibernate.entities.Client;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final BaseDAO baseDAO;

    @Autowired
    public ClientRepositoryImpl(BaseDAO baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    public Client findClientById(Long id) {
        Client client = baseDAO.getCurrentSession().find(Client.class, id);
        return client;
    }

    @Override
    public List<Client> findClientByName(String name) {
        Criteria criteria = baseDAO.getCurrentSession().createCriteria(Client.class);
        criteria.add(Restrictions.like("firstName", name));
        return criteria.list();
    }

    @Override
    public List<Client> getAllClient() {
        Criteria criteria = baseDAO.getCurrentSession().createCriteria(Client.class);
        return criteria.list();
    }

    @Override
    public void saveClient(Client client) {
        baseDAO.getCurrentSession().beginTransaction();
        baseDAO.getCurrentSession().persist(client);
        baseDAO.getCurrentSession().getTransaction().commit();
        baseDAO.getCurrentSession().close();
    }

    @Override
    public Client removeClient(Long id) {
        Transaction transaction = baseDAO.getCurrentSession().getTransaction();
        transaction.begin();
        Client client = baseDAO.getCurrentSession().find(Client.class, id);
        baseDAO.getCurrentSession().remove(client);
        transaction.commit();
        baseDAO.getCurrentSession().close();
        return client;
    }
}

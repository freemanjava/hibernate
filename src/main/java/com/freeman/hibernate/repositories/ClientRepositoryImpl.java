package com.freeman.hibernate.repositories;

import com.freeman.hibernate.dao.BaseDAO;
import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.entities.ClientWallet;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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
    public ClientWallet findClientById(Long id) {
        Client client = baseDAO.getCurrentSession().find(Client.class, id);
        ClientWallet clientWithWallet = baseDAO.getCurrentSession().find(ClientWallet.class, client.getId());
        return clientWithWallet;
    }

    @Override
    public List<Client> findClientByName(String name) {
        /*Criteria criteriaClient = baseDAO.getCurrentSession().
                createCriteria(ClientWallet.class).
                createAlias("client", "c", JoinType.INNER_JOIN);*/

        Criteria criteriaClient = baseDAO.getCurrentSession().createCriteria(Client.class);
        Criteria criteriaWallet = baseDAO.getCurrentSession().createCriteria(ClientWallet.class);
        criteriaWallet.add(Restrictions.eq("id.client.firstName", name));

        criteriaWallet.add(Restrictions.eq("client", Client.builder().id(2l).firstName("Petija").build())).list();

        Criteria clients = criteriaClient.add(Restrictions.like("firstName", name));

        List<ClientWallet> list = criteriaWallet.list();

        return clients.list();
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

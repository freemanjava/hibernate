package com.freeman.hibernate.repositories;

import com.freeman.hibernate.dao.BaseDAO;
import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.entities.ClientWallet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientWalletRepositoryImpl implements ClientWalletRepository {

    private final BaseDAO baseDAO;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientWalletRepositoryImpl(BaseDAO baseDAO, ClientRepository clientRepository) {
        this.baseDAO = baseDAO;
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientWallet getClientWalletByClientId(Long clientId) {
        Client client = baseDAO.getCurrentSession().find(Client.class, clientId);
        return baseDAO.getCurrentSession().find(ClientWallet.class, client.getId());
    }

    @Override
    public ClientWallet getClientWalletByClientName(String clientName) {
        return null;
    }

    @Override
    public List<Client> findClientsByCurrency(String currency) {
        List<Client> allClient = clientRepository.getAllClient();
        Criteria criteria = baseDAO.getCurrentSession().createCriteria(ClientWallet.class);
        criteria.add(Restrictions.eq("currency", currency));
        return criteria.list();
    }

    @Override
    public List<Client> findClientsByAmount(Double amount) {
        return null;
    }

    @Override
    public List<ClientWallet> getAllClientsWallets() {
        return null;
    }

    @Override
    public List<ClientWallet> getAllClientsWalletsWithClientSNames() {
        return null;
    }

    @Override
    public void saveClientWallet(Client client, ClientWallet clientWallet) {

    }

    @Override
    public ClientWallet removeClientWallet(Client client) {
        return null;
    }
}

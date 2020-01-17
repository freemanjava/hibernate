package com.freeman.hibernate.repositories;

import com.freeman.hibernate.entities.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client findClientById(Long id) {
        Client client = entityManager.find(Client.class, id);
        return client;
    }

    @Override
    public Client findClientByName(String name) {
        return null;
    }

    @Override
    public List<Client> getAllClient() {
        return null;
    }

    @Override
    public void saveClient() {

    }

    @Override
    public Client removeClient(Long id) {
        return null;
    }
}

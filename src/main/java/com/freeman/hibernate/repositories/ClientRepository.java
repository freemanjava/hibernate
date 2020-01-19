package com.freeman.hibernate.repositories;

import com.freeman.hibernate.entities.Client;

import java.util.List;

public interface ClientRepository {

    Client findClientById(Long Id);
    List<Client> findClientByName(String name);
    List<Client> getAllClient();
    void saveClient(Client client);
    Client removeClient(Long id);


}

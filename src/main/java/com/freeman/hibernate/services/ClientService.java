package com.freeman.hibernate.services;

import com.freeman.hibernate.entities.Client;

import java.util.List;

public interface ClientService {

    Client findClientById(Long id);
    List<Client> findClientByName(String name);
    List<Client> getAllClient();
    void saveClient(Client client);
    Client removeClient(Long id);
}

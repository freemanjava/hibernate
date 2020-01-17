package com.freeman.hibernate.repositories;

import com.freeman.hibernate.entities.Client;

import java.util.List;

public interface ClientRepository {

    Client findClientById(Long Id);
    Client findClientByName(String name);
    List<Client> getAllClient();
    void saveClient();
    Client removeClient(Long id);


}

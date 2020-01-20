package com.freeman.hibernate.services;

import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.entities.ClientWallet;

import java.util.List;

public interface ClientService {

    ClientWallet findClientById(Long id);
    List<Client> findClientByName(String name);
    List<Client> getAllClient();
    void saveClient(Client client);
    Client removeClient(Long id);
}

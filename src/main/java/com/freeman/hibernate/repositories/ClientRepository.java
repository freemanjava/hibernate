package com.freeman.hibernate.repositories;

import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.entities.ClientWallet;

import java.util.List;

public interface ClientRepository {

    ClientWallet findClientById(Long Id);
    List<Client> findClientByName(String name);
    List<Client> getAllClient();
    void saveClient(Client client);
    Client removeClient(Long id);


}

package com.freeman.hibernate.services;

import com.freeman.hibernate.entities.Client;

public interface ClientService {

    Client findClientById(Long id);
    void saveClient();
}

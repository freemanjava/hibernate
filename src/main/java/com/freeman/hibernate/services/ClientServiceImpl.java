package com.freeman.hibernate.services;

import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findClientById(Long id) {
        return clientRepository.findClientById(id);
    }

    @Override
    public void saveClient() {

    }
}

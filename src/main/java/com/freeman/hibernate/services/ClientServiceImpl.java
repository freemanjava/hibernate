package com.freeman.hibernate.services;

import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.entities.ClientWallet;
import com.freeman.hibernate.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientWallet findClientById(Long id) {
        return clientRepository.findClientById(id);
    }

    @Override
    public List<Client> findClientByName(String name) {
        return clientRepository.findClientByName(name);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.getAllClient();
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.saveClient(client);
    }

    @Override
    public Client removeClient(Long id) {
        Client client = clientRepository.removeClient(id);
        return client;
    }

}

package com.freeman.hibernate.services;

import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.entities.ClientWallet;
import com.freeman.hibernate.repositories.ClientWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientWalletServiceImpl implements ClientWalletService {

    private final ClientWalletRepository clientWalletRepository;

    @Autowired
    public ClientWalletServiceImpl(ClientWalletRepository clientWalletRepository) {
        this.clientWalletRepository = clientWalletRepository;
    }

    @Override
    public ClientWallet getClientWalletByClientId(Long clientId) {
        return clientWalletRepository.getClientWalletByClientId(clientId);
    }

    @Override
    public ClientWallet getClientWalletByClientName(String clientName) {
        return null;
    }

    @Override
    public List<Client> findClientsByCurrency(String currency) {
        return clientWalletRepository.findClientsByCurrency(currency);
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

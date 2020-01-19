package com.freeman.hibernate.services;

import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.entities.ClientWallet;

import java.util.List;

public interface ClientWalletService {
    ClientWallet getClientWalletByClientId(Long clientId);
    ClientWallet getClientWalletByClientName(String clientName);
    List<Client> findClientsByCurrency(String currency);
    List<Client> findClientsByAmount(Double amount);
    List<ClientWallet> getAllClientsWallets();
    List<ClientWallet> getAllClientsWalletsWithClientSNames();
    void saveClientWallet(Client client, ClientWallet clientWallet);
    ClientWallet removeClientWallet(Client client);
}

package com.freeman.hibernate.repositories;

import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.entities.ClientWallet;

import java.util.List;

public interface ClientWalletRepository {
    ClientWallet getClientWalletByClientId(Long clientId);
    ClientWallet getClientWalletByClientName(String clientName);
    List<Client> findClientsByCurrency(String currency);
    List<Client> findClientsByAmount(Double amount);
    List<ClientWallet> getAllClientsWallets();
    List<ClientWallet> getAllClientsWalletsWithClientSNames();
    void saveClientWallet(Client client, ClientWallet clientWallet);
    ClientWallet removeClientWallet(Client client);
}

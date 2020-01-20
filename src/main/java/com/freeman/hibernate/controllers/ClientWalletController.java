package com.freeman.hibernate.controllers;

import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.entities.ClientWallet;
import com.freeman.hibernate.services.ClientService;
import com.freeman.hibernate.services.ClientWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class ClientWalletController {

    private final ClientWalletService clientWalletService;

    @Autowired
    public ClientWalletController(ClientWalletService clientWalletService) {
        this.clientWalletService = clientWalletService;
    }

    @GetMapping("/id/{id}")
    public ClientWallet getClientById (@PathVariable Long id){
        ClientWallet clientWalletByClientId = clientWalletService.getClientWalletByClientId(id);
        return clientWalletByClientId;
    }

    @GetMapping("/currency/{currency}")
    public List<Client> findClientsByCurrency(@PathVariable String currency) {
        return clientWalletService.findClientsByCurrency(currency);
    }

    /*@GetMapping("/name/{name}")
    public List<Client> findClientByName(@PathVariable String name) {
        return clientWalletService.findClientByName(name);
    }

    @GetMapping()
    public List<Client> getAllClient() {
        return clientWalletService.getAllClient();
    }

    @PutMapping("/client")
    public void saveClient(@RequestBody Client client) {
        clientWalletService.saveClient(client);
    }

    @DeleteMapping("/remove/{id}")
    public Client removeClient(@PathVariable Long id) {
        Client client = clientWalletService.removeClient(id);
        return client;
    }*/
}

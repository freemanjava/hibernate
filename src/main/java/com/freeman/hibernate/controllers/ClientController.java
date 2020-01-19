package com.freeman.hibernate.controllers;

import com.freeman.hibernate.entities.Client;
import com.freeman.hibernate.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/id/{id}")
    public Client getClientById (@PathVariable Long id){
        Client client = clientService.findClientById(id);
        return client;
    }

    @GetMapping("/name/{name}")
    public List<Client> findClientByName(@PathVariable String name) {
        return clientService.findClientByName(name);
    }

    @GetMapping()
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    @PutMapping("/client")
    public void saveClient(@RequestBody Client client) {
        clientService.saveClient(client);
    }

    @DeleteMapping("/remove/{id}")
    public Client removeClient(@PathVariable Long id) {
        Client client = clientService.removeClient(id);
        return client;
    }
}

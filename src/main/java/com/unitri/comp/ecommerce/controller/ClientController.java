package com.unitri.comp.ecommerce.controller;


import com.unitri.comp.ecommerce.model.entity.Client;
import com.unitri.comp.ecommerce.model.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    final ClientService clientService;

    public ClientController() {
        this.clientService = new ClientService();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable int id) {
        return clientService.findById(id);
    }
    @PostMapping("/create")
    void create(@RequestBody Client client){
        clientService.create(client);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  int id) {
        clientService.deleteById(id);
    }
    @GetMapping
    List<Client> findAll(){
        return clientService.findAll();
    }
}

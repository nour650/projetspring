package com.example.pfa.clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/")
public class ClientController {


    private final  ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("clients/")
    public Client addClient(@RequestBody Client client){
        clientService.addClient(client);
        return client;
    }
    @GetMapping("clients/")
    public List<Client> getclients(){
        return clientService.getClients();
    }
    @GetMapping("clients/{id}")
    public Client getClient(@PathVariable Long id){
        return clientService.getClient(id);
    }
    @DeleteMapping("clients/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
    }
    @PatchMapping("clients/{id}")
    public void updateClient(@PathVariable("id") Long id , @RequestBody Client client){

        clientService.updateClient(id,client);
    }
}

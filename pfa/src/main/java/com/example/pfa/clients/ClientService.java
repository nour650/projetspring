package com.example.pfa.clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public void addClient(Client client){
        clientRepository.save(client);
    }
    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    public  Client getClient(Long id){
        return clientRepository.findById(id).get();
    }
    public void deleteClient(Long id){
        boolean exist=clientRepository.existsById(id);
        if (exist){
            clientRepository.deleteById(id);
        }
        else {
            throw new IllegalStateException(
                    "client with id" +id+ "does not exist"
            );
        };
    }
    public void updateClient(Long id , Client client){
        boolean exist = clientRepository.existsById(id);
        if (exist){
            clientRepository.save(client);

        }
        else {
            throw new IllegalStateException(
                    "client with id" +id+ "does not exist"
            );
        }
    }


}

package com.botplan.backend.services;

import com.botplan.backend.dto.ClientDTO;
import com.botplan.backend.entity.Client;
import com.botplan.backend.mapper.ClientMapper;
import com.botplan.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO getClient(Long id) {
        return ClientMapper.toDto(clientRepository.findClientById(id));
    }

    public ClientDTO addClient(Client client) {
        return ClientMapper.toDto(clientRepository.save(client));
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClientDTO updateClient(Client client, Long id) {
        Client entity = clientRepository.findClientById(id);
        if (entity != null) {
            client.setId(entity.getId());
            return ClientMapper.toDto(clientRepository.save(client));
        }
        return null;
    }

    public void deleteClient(Long id) {
        Client entity = clientRepository.findClientById(id);
        clientRepository.delete(entity);
    }
}

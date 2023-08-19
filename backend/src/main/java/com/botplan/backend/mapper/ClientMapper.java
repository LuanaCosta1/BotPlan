package com.botplan.backend.mapper;

import com.botplan.backend.dto.ClientDTO;
import com.botplan.backend.entity.Client;
import org.springframework.stereotype.Component;

public class ClientMapper {

    public static Client toEntity(ClientDTO dto) {
        Client client = new Client();
        client.setClientName(dto.getClientName());
        client.setContactPerson(dto.getContactPerson());
        client.setEmail(dto.getEmail());
        client.setPhone(dto.getPhone());
        return client;
    }

    public static ClientDTO toDto(Client entity) {
        return ClientDTO.builder()
                .clientName(entity.getClientName())
                .contactPerson(entity.getContactPerson())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .build();
    }
}

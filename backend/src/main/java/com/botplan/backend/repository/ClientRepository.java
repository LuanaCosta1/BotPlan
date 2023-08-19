package com.botplan.backend.repository;

import com.botplan.backend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
    Client findClientById(Long id);
}

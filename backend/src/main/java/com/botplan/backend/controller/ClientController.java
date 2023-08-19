package com.botplan.backend.controller;

import com.botplan.backend.dto.ClientDTO;
import com.botplan.backend.dto.EmployeeDTO;
import com.botplan.backend.entity.Client;
import com.botplan.backend.response.BaseResponse;
import com.botplan.backend.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("clients")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/")
    public BaseResponse<ClientDTO> add(@RequestBody Client client) {
        ClientDTO savedClient = clientService.addClient(client);
        return BaseResponse.<ClientDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(clientService.addClient(client)).build();
    }

    @GetMapping("/")
    public BaseResponse<List<ClientDTO>> selectAll() {
        List<ClientDTO> allClients = clientService.getAllClients();
        return BaseResponse.<List<ClientDTO>>builder()
                .httpCode(200)
                .message("OK")
                .response(clientService.getAllClients()).build();
    }

    @GetMapping("/{id}")
    public BaseResponse<ClientDTO> getClient(@PathVariable("id") Long id) {
        ClientDTO clientDTO = clientService.getClient(id);
        return BaseResponse.<ClientDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(clientService.getClient(id))
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<ClientDTO> update(@RequestBody Client client, @PathVariable("id") Long id) {
        ClientDTO updatedClient = clientService.updateClient(client, id);
        return BaseResponse.<ClientDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(updatedClient).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}

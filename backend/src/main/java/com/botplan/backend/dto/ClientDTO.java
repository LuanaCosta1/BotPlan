package com.botplan.backend.dto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDTO {
    private String clientName;
    private String contactPerson;
    private String email;
    private String phone;
}

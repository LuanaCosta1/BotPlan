package com.botplan.backend.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private String clientName;
    private String contactPerson;
    private String email;
    private String phone;
}

package com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletionResponse {
    private  boolean success;
    private  String message;
}

package com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminConfigurationDTO {
    private Long adminConfigurationId;
    private String username;
    private String password;
}

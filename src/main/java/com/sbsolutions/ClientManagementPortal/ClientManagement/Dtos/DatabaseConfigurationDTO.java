package com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseConfigurationDTO {
    private Long databaseConfigurationId;
    private String dbName;
    private String dbUrl;
    private String dbCredentialUsername;
    private String dbCredentialPassword;
}

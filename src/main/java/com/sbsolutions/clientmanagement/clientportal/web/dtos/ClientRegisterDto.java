package com.sbsolutions.clientmanagement.clientportal.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegisterDto {

    private String name;
    private String subdomain;
    private String dbName;
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;

    // Schema information (optional)
    private String schemaName;

    // Isolation type - "DATABASE" or "SCHEMA"
    private String isolationType = "DATABASE"; // Default to database-per-tenant

    private  String adminUsername;
    private  String adminPassword;
    private  String adminEmail;

}

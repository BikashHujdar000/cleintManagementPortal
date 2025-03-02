package com.sbsolutions.ClientManagementPortal.ClientManagement.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class DatabaseConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long databaseConfigurationId;

    private String dbName;
    private String dbUrl;
    private String dbCredentialUsername;
    private String dbCredentialPassword;
}

package com.sbsolutions.clientmanagement.clientportal.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantResponse {
    private Long id;
    private String name;
    private String subdomain;
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private String schemaName;
    private String isolationType;
    private Boolean active;
    private String createdAt;

}

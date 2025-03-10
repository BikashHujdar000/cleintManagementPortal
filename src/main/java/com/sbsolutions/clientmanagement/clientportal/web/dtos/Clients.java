package com.sbsolutions.clientmanagement.clientportal.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clients {
    private  String subdomain;
    private  String dbUrl ;
    private  String dbUsername;
    private  String dbPassword;
    private  String schemaName;

}

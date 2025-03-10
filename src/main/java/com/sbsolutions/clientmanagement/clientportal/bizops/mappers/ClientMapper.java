package com.sbsolutions.clientmanagement.clientportal.bizops.mappers;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.Tenant;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.Clients;
import org.springframework.stereotype.Component;

public class ClientMapper {

    public static  Clients toClientsDto(Tenant tenant) {
        if (tenant == null || tenant.getDatabaseConfiguration() == null) {
            return null; // Handle null case gracefully
        }

        return new Clients(
            tenant.getSubDomainName(),
            tenant.getDatabaseConfiguration().getDbUrl(),
            tenant.getDatabaseConfiguration().getDbCredentialUsername(),
            tenant.getDatabaseConfiguration().getDbCredentialPassword(),
            tenant.getSchemaName()
        );
    }
}

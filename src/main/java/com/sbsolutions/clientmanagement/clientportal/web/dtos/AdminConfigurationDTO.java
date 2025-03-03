package com.sbsolutions.clientmanagement.clientportal.web.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminConfigurationDTO {
    private Long adminConfigurationId;
    private String username;
    private String password;
}

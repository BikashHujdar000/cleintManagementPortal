package com.sbsolutions.clientmanagement.clientportal.web.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThemeConfigurationDTO {
    private Long themeConfigurationId;
    private String primaryColor;
    private String secondaryColor;
    private String logoUrl;
    private String faviconUrl;
}

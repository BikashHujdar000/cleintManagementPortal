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
public class ThemeConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long themeConfigurationId;

    private String primaryColor;
    private String secondaryColor;
    private String logoUrl;
    private String faviconUrl;
}

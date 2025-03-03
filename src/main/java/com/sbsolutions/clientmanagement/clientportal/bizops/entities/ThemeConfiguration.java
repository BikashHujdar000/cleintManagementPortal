package com.sbsolutions.clientmanagement.clientportal.bizops.entities;

import jakarta.persistence.*;
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

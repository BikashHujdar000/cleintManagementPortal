package com.sbsolutions.clientmanagement.clientportal.bizops.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class AdminConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminConfigurationId;

    private String username;
    private String password;
    private  String email ;
}

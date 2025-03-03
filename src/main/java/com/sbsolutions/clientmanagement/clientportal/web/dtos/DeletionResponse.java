package com.sbsolutions.clientmanagement.clientportal.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletionResponse {
    private  boolean success;
    private  String message;
}

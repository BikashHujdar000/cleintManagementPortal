package com.sbsolutions.clientmanagement.clientportal.web.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceNotFoundException  extends  RuntimeException{

    private  String resourceName;
    private  String fieldName;
    private  Long fieldValue;


    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s with the %s : %d  not found", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

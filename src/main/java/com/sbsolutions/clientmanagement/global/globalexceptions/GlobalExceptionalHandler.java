package com.sbsolutions.clientmanagement.global.globalexceptions;


import com.sbsolutions.clientmanagement.global.globalresponse.RestResponse;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.DatabaseOperationException;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
        return new RestResponse<>().error(exception.getMessage(), "404");
    }
    @ExceptionHandler(DatabaseOperationException.class)
    public  ResponseEntity<?> databaseOperationExceptionHandler(DatabaseOperationException exception){
        return  new RestResponse<>().error(null,exception.getMessage(),"500");
    }

}

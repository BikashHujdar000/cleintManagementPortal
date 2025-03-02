package com.sbsolutions.ClientManagementPortal.Global.Exceptions;


import com.sbsolutions.ClientManagementPortal.Global.GlobalResponse.RestResponse;
import org.springframework.http.HttpStatus;
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

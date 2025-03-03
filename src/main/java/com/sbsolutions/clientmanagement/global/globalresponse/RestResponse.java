package com.sbsolutions.clientmanagement.global.globalresponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sbsolutions.clientmanagement.global.constants.PaginationInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
public class RestResponse<T> {
    private String code;
    private LocalDateTime timeStamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PaginationInfo meta;
    private T data;
    private String message;

    public RestResponse() {
    }

    public RestResponse(String code, LocalDateTime timeStamp, PaginationInfo meta, T data, String message) {
        this.code = code;
        this.timeStamp = timeStamp;
        this.meta = meta;
        this.data = data;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public PaginationInfo getMeta() {
        return meta;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public ResponseEntity<?> oKWithPaginatedPayload(T data, PaginationInfo meta, String message) {
        return new ResponseEntity<>(new RestResponse<>("200", LocalDateTime.now(), meta, data, message), HttpStatus.OK);
    }

    public ResponseEntity<?> oKWithPayload(T data, String message) {
        return new ResponseEntity<>(new RestResponse<>("200", LocalDateTime.now(), null, data, message), HttpStatus.OK);
    }

    public ResponseEntity<?> createdStatusWithPayload(T data, String message) {
        return new ResponseEntity<>(new RestResponse<>("201", LocalDateTime.now(), null, data, message), HttpStatus.CREATED);
    }

    public ResponseEntity<?> error(T errorData, String message, String errorCode) {
        return new ResponseEntity<>(new RestResponse<>(errorCode, LocalDateTime.now(), null, errorData, message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<?> error(String message, String errorCode) {
        return new ResponseEntity<>(new RestResponse<>(errorCode, LocalDateTime.now(), null, null, message), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.spring.schoolapplication.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonUtils {

    public static ResponseEntity<Object> getSuccessResponse() {
        return new ResponseEntity<>("{\"status\":\"OK\"}", HttpStatus.OK);
    }

    public static ResponseEntity<Object> getFailureResponse() {
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }

}

package com.application.pinlocation.exception;

import com.application.pinlocation.dto.ResponseDTO;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    private static final String message = " Exception while processing REST Request";

    @org.springframework.web.bind.annotation.ExceptionHandler(PinDetailsNotFoundException.class)
    public ResponseEntity<ResponseDTO> handlerBookStoreException(PinDetailsNotFoundException pinDetailsNotFoundException){
        ResponseDTO responseDTO = new ResponseDTO(message,pinDetailsNotFoundException.getMessage(), HttpStatus.BAD_REQUEST );
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyPresent.class)
    public ResponseEntity<ResponseDTO> handlerBookStoreException(UserAlreadyPresent userAlreadyPresent){
        ResponseDTO responseDTO = new ResponseDTO(message,userAlreadyPresent.getMessage(),HttpStatus.BAD_REQUEST );
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO> handlerBookStoreException(UserNotFoundException userNotFoundException){
        ResponseDTO responseDTO = new ResponseDTO(message,userNotFoundException.getMessage(),HttpStatus.BAD_REQUEST );
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ResponseDTO> missingRequestHeaderException(MissingRequestHeaderException exception){
        ResponseDTO responseDTO = new ResponseDTO(message ,"Enter your Token",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<ResponseDTO> missingRequestHeaderException(MalformedJwtException exception){
        ResponseDTO responseDTO = new ResponseDTO(message ,"Enter your Token",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ResponseDTO> tokenExpiredException(ExpiredJwtException exception){
        ResponseDTO responseDTO = new ResponseDTO(message ,"Your Token is Expired",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }
}

package com.umb.mvc.login.authenticator.commons.exceptions;

import com.umb.mvc.login.authenticator.model.AuthenticationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    public static final String NO_AUTORIZADO = "El usuario no es valido";
    private static final String ERROR_DE_CLIENTE = "El usuario o contraseña estan vacios";

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<AuthenticationResponse> handleErrorApplication(ApplicationException e){
        log.error(e.getMessage());
        AuthenticationResponse response = AuthenticationResponse.builder().message(NO_AUTORIZADO).login(Boolean.FALSE).build();
        log.info("------------------------------------------------------------------");
        log.info(response.toString());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ClientRequestException.class)
    public ResponseEntity<AuthenticationResponse> handleClientError(ClientRequestException e){
        log.error(e.getMessage());
        AuthenticationResponse response = AuthenticationResponse.builder().message(ERROR_DE_CLIENTE).login(Boolean.FALSE).build();
        log.info("------------------------------------------------------------------");
        log.info(response.toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

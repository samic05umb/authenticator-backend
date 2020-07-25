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

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<AuthenticationResponse> handleError(ApplicationException e){
        log.error(e.getMessage());
        AuthenticationResponse response = AuthenticationResponse.builder().message(NO_AUTORIZADO).login(Boolean.FALSE).build();
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}

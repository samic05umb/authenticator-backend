package com.umb.mvc.login.authenticator.controller;

import com.umb.mvc.login.authenticator.commons.exceptions.ApplicationException;
import com.umb.mvc.login.authenticator.model.AuthenticationRequest;
import com.umb.mvc.login.authenticator.model.AuthenticationResponse;
import com.umb.mvc.login.authenticator.view.AuthenticationHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@AllArgsConstructor
@RequestMapping("auth")
public class AuthController {
private final AuthenticationHandler authenticationHandler;
    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> getSavingsBalance(
            @RequestBody @Validated AuthenticationRequest request) throws ApplicationException {
        return ResponseEntity.ok(authenticationHandler.authenticate(request));
    }
}

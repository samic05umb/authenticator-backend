package com.umb.mvc.login.authenticator.view;

import com.umb.mvc.login.authenticator.commons.exceptions.ApplicationException;
import com.umb.mvc.login.authenticator.commons.exceptions.ClientRequestException;
import com.umb.mvc.login.authenticator.model.AuthenticationRequest;
import com.umb.mvc.login.authenticator.model.AuthenticationResponse;
import com.umb.mvc.login.authenticator.model.dto.Users;
import com.umb.mvc.login.authenticator.model.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.function.Predicate;

@Component
@AllArgsConstructor
@Slf4j
public class AuthenticationHandler {
    private final static String SUCCESS_MESSAGE = "Usuario valido";
    public static final String NO_VALIDADO = "No fue posible validar el usuario %s";
    public static final String INTENTO_CONEXION = "Usuario: %s se esta intentando conectar";
    public static final String USUARIO_CONECTADO = "Usuario: %s se ha conectado con el usuario %s";
    private static final Predicate<AuthenticationRequest> VALIDATE_IF_NULL = a ->
            StringUtils.isEmpty(a.getUsername())||StringUtils.isEmpty(a.getPassword());
    public static final String BAD_REQUEST = "El usuario o clave esta vacio";
    private final UsersRepository repository;

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws ApplicationException, ClientRequestException {
        if(VALIDATE_IF_NULL.test(request)){
            throw new ClientRequestException(BAD_REQUEST);
        }
        log.info(String.format(INTENTO_CONEXION,request.getUsername()));
        Users user = repository.findByUsuarioAndAndClave(request.getUsername(),request.getPassword());
        if(Objects.isNull(user)){
            throw new ApplicationException(String.format(NO_VALIDADO,request.getUsername()));
        }
        log.info(String.format(USUARIO_CONECTADO,user.getNombre(),user.getUsuario()));
        AuthenticationResponse response = AuthenticationResponse.builder()
                .message(SUCCESS_MESSAGE)
                .login(Boolean.TRUE)
                .user(user)
                .build();
        log.info("------------------------------------------------------------------");
        log.info(response.toString());
        return response;
    }
}

package com.umb.mvc.login.authenticator.model;

import com.umb.mvc.login.authenticator.model.dto.Users;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthenticationResponse {
    private String message;
    private Boolean login;
    private Users user;

    @Override
    public String toString() {
        return "La respuesta es: {" +
                "message='" + message + '\'' +
                ", login=" + login +
                ", user=" + user +
                '}';
    }
}

package com.umb.mvc.login.authenticator.model.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String numeroDocumento;
    private String tipoDocumento;
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private String numeroCelular;
    private String correoElectronico;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", numeroDocumento='" + "xxxxxxxx" + '\'' +
                ", tipoDocumento='" + "xxxxxxxx" + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + "xxxxxxxx" + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}

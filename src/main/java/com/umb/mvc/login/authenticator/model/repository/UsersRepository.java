package com.umb.mvc.login.authenticator.model.repository;

import com.umb.mvc.login.authenticator.model.dto.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    
    public Users findByUsuarioAndAndClave(String usuario, String clave);
}

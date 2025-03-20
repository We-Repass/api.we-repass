package com.apisecurityapp.api_we_repass.repositoryI;

import com.apisecurityapp.api_we_repass.repository.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.query.Procedure;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Procedure(name = "f_inicio_sesion")
    public String inicioSesion(@Param("in_user") int dni, @Param("in_password") String contrasenia);
}

package com.apisecurityapp.api_we_repass.repositoryI;

import com.apisecurityapp.api_we_repass.repository.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.query.Procedure;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query(value = "SELECT f_inicio_sesion(:usuario, :contrasenia)", nativeQuery = true)
    String inicioSesion(@Param("usuario") String usuario, @Param("contrasenia") String contrasenia);

    @Query(value = "SELECT f_lista_alumnos()", nativeQuery = true)
    String listarAlumnos();

}
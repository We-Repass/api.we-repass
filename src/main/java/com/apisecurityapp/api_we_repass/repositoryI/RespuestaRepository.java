package com.apisecurityapp.api_we_repass.repositoryI;

import com.apisecurityapp.api_we_repass.repository.Respuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {

    @Query(value = "SELECT f_guardar_respuesta(:idpregunta, :idsemana, :idusuario, :respuesta)", nativeQuery = true)
    String guardarRespuesta(@Param("idpregunta")int idpregunta,
                            @Param("idsemana") int idsemana,
                            @Param("idusuario") int idusuario,
                            @Param("respuesta") String respuesta);

    @Query(value = "SELECT f_ver_nota(:idusuario)", nativeQuery = true)
    String verNota(@Param("idusuario") int idusuario);

}
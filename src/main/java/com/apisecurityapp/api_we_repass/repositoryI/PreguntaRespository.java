package com.apisecurityapp.api_we_repass.repositoryI;

import com.apisecurityapp.api_we_repass.repository.Pregunta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PreguntaRespository extends CrudRepository<Pregunta, Long> {

    @Query(value = "SELECT f_crear_examen(:idsemana, :tema, :dificultad, :preguntas, :opciones, :respuesta)", nativeQuery = true)
    String CrearExamen(
            @Param("idsemana") int idsemana,
            @Param("tema") String tema,
            @Param("dificultad") String dificultad,
            @Param("preguntas") String preguntas,
            @Param("opciones") String opciones,
            @Param("respuesta") String respuesta
    );
}
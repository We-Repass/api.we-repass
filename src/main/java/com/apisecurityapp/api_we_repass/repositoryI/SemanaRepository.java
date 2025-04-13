package com.apisecurityapp.api_we_repass.repositoryI;

import com.apisecurityapp.api_we_repass.repository.Semana;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SemanaRepository extends CrudRepository<Semana, Long> {

    @Query(value = "SELECT f_ver_semana()", nativeQuery = true)
    String verSemana();

}

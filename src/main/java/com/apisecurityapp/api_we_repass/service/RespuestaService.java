package com.apisecurityapp.api_we_repass.service;

import com.apisecurityapp.api_we_repass.repository.Respuesta;
import com.apisecurityapp.api_we_repass.repositoryI.RespuestaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepository respuestaRepository;


    public String guardarRespuesta(List<Respuesta> respuestas) throws Exception{
        StringBuilder resultado = new StringBuilder();
        for (Respuesta respuesta : respuestas) {
           String data = respuestaRepository.guardarRespuesta(
                    respuesta.getIdpregunta(),
                    respuesta.getIdsemana(),
                    respuesta.getIdusuario(),
                    respuesta.getRespuesta());
            resultado.append(data).append("\n");
        }
        return resultado.toString();
    }

    public String verNota(Respuesta respuestas) throws  Exception{
        return respuestaRepository.verNota(respuestas.getIdusuario());
    }
}

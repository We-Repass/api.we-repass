package com.apisecurityapp.api_we_repass.service;

import com.apisecurityapp.api_we_repass.repository.Pregunta;
import com.apisecurityapp.api_we_repass.repositoryI.PreguntaRespository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRespository preguntaRespository;

    private ObjectMapper objectMapper = new ObjectMapper();  // Usar Jackson para convertir a JSON

    public String CrearExamen(List<Pregunta> preguntas) throws Exception {
        StringBuilder resultado = new StringBuilder();

        for (Pregunta pregunta : preguntas) {
            String opcionesJson = convertListToJson(pregunta.getOpciones());

            String data = preguntaRespository.CrearExamen(
                    pregunta.getIdsemana(),
                    pregunta.getTema(),
                    pregunta.getDificultad(),
                    pregunta.getPreguntas(),
                    opcionesJson,  // Pasar las opciones como String JSON
                    pregunta.getRespuesta()
            );
            resultado.append(data).append("\n");
        }

        return resultado.toString();
    }

    // Método para convertir una lista a JSON String
    private String convertListToJson(List<String> list) throws JsonProcessingException {
        return objectMapper.writeValueAsString(list);
    }
}

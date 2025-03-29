package com.apisecurityapp.api_we_repass.controller;

import com.apisecurityapp.api_we_repass.repository.Pregunta;
import com.apisecurityapp.api_we_repass.repository.Usuario;
import com.apisecurityapp.api_we_repass.service.PreguntaService;
import com.apisecurityapp.api_we_repass.service.SemanaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import com.apisecurityapp.api_we_repass.service.UsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/api")
public class WeRepassController {
    private static final Logger logger = LoggerFactory.getLogger(WeRepassController.class);

    @Autowired
    private UsuarioService usuarioServicio;

    @Autowired
    private SemanaService semanaService;

    @Autowired
    private PreguntaService preguntaService;

    //USUARIO

    @RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
    public ResponseEntity<?> validarLogin(@RequestBody Usuario usuario) throws Exception {

        String data = usuarioServicio.InicioSesion(usuario);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/lista/alumnos", method = RequestMethod.GET)
    public ResponseEntity<?> listarAlumnos() throws Exception {

        String data = usuarioServicio.listarAlumnos();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    //SEMANAS

    @RequestMapping(value = "/ver/semana", method = RequestMethod.GET)
    public ResponseEntity<?> verSemana() throws Exception {

        String data = semanaService.verSemana();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    //EXAMEN

    @RequestMapping(value = "/crear/examen", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> CreaExamen(@RequestBody List<Pregunta> preguntas) throws Exception {
        logger.info("Recibidas " + preguntas.size() + " preguntas.");
        for (Pregunta pregunta : preguntas) {
            logger.info("Pregunta: " + pregunta.getPreguntas());
            logger.info("Opciones: " + pregunta.getOpciones());
        }

        String data = preguntaService.CrearExamen(preguntas);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Examen guardado con éxito");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/ver/examen", method = RequestMethod.POST)
    public ResponseEntity<?> VerExamen(@RequestBody Map<String, Integer> requestBody) throws Exception {
        // Extraemos el idsemana del mapa
        Integer idsemana = requestBody.get("idsemana");
        if (idsemana == null) {
            return new ResponseEntity<>("idsemana es requerido", HttpStatus.BAD_REQUEST);
        }

        logger.info("Recibido idsemana: " + idsemana);
        String data = preguntaService.VerExamen(idsemana); // Enviar solo el idsemana
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


}

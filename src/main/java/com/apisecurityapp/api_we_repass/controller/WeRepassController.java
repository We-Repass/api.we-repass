package com.apisecurityapp.api_we_repass.controller;

import com.apisecurityapp.api_we_repass.repository.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import com.apisecurityapp.api_we_repass.service.UsuarioService;

@EnableScheduling
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/api")
public class WeRepassController {
    private static final Logger logger = LoggerFactory.getLogger(WeRepassController.class);

    @Autowired
    private UsuarioService usuarioServicio;

    @RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
    public ResponseEntity<?> validarLogin(@RequestBody Usuario usuario) throws Exception {

        String data = usuarioServicio.InicioSesion(usuario);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}

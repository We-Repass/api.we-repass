package com.apisecurityapp.api_we_repass.service;

import com.apisecurityapp.api_we_repass.repository.Usuario;
import com.apisecurityapp.api_we_repass.repositoryI.UsuarioRepository;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String InicioSesion(Usuario usuario) throws  Exception{
        return usuarioRepository.inicioSesion(
                usuario.getDni(),
                usuario.getContrasenia()
        );
    }

}

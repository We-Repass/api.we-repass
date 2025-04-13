package com.apisecurityapp.api_we_repass.service;

import com.apisecurityapp.api_we_repass.repository.Usuario;
import com.apisecurityapp.api_we_repass.repositoryI.SemanaRepository;
import com.apisecurityapp.api_we_repass.repositoryI.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemanaService {
    @Autowired
    private SemanaRepository semanaRepository;

    public String verSemana() throws  Exception{
        return semanaRepository.verSemana();
    }

}

package ort.sistema.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ort.sistema.model.Usuario;
import ort.sistema.repository.UsuarioRepository;

@Service 
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;

    }


    public boolean validarLogin(String email, String password){
        boolean existe = false;
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if(usuarioOpt.isPresent()){
            Usuario usuario = usuarioOpt.get();
            if(usuario.getPassword().equals(password)){
                existe = true;
            }
        }

        return existe;
    }








}

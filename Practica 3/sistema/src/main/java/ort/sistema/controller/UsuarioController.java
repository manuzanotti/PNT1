package ort.sistema.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ort.sistema.dto.LoginDto;
import ort.sistema.service.UsuarioService;

@RestController 
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public  UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }


    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody LoginDto login){
        boolean validar = usuarioService.validarLogin(login.getEmail(), login.getPassword());

        if(validar){
            return ResponseEntity.ok("Login existos");    
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    }











}

package ort.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ort.sistema.model.Usuario;

@Repository 
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    
}

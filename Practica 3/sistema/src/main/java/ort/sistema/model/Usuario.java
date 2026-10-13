package ort.sistema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Usuario {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String legajo;
    private String nombre;
    private String apellido;
    private String cargo;
    private String email;
    private String password;
    
    public Usuario() {
        
        }

    
    public Usuario(Long id, String legajo, String nombre, String apellido, String cargo, String email,
            String password) {
       
        this.id = id;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.email = email;
        this.password = password;
    }
    
    
    
    
    public Long getId() {
        return id;
    }
    public String getLegajo() {
        return legajo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCargo() {
        return cargo;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    













}


package ort.sistema.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Ticket {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String prioridad;
    private String estado;
    private String solicitante;
    private String categoria;
    private String areaResponsable;
   
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fechaCreacion;
   
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fechaCierre;
    
    
    public Ticket(){

    }

    public Ticket(String titulo, String descripcion, String prioridad, String estado, String solicitante, String categoria, String areaResponsable){
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
        this.setPrioridad(prioridad);
        this.setEstado(estado);
        this.setSolicitante(solicitante);
        this.setCategoria(categoria);
        this.setAreaResponsable(areaResponsable);
        this.setFechaCreacion(LocalDateTime.now());
        this.setFechaCierre(null);
    }




    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getPrioridad() {
        return prioridad;
    }
    public String getEstado() {
        return estado;
    }
    public String getSolicitante() {
        return solicitante;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getAreaResponsable() {
        return areaResponsable;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAreaResponsable(String areaResponsable) {
        this.areaResponsable = areaResponsable;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaCierre(LocalDateTime fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    
  
   

    
    
    

}

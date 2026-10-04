package ort.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ort.sistema.model.Ticket;

public interface TicketRepository extends JpaRepository <Ticket, Long> {

    
} 
    

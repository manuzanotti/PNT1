package ort.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ort.sistema.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository <Ticket, Long> {

    
} 
    

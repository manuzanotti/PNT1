package ort.sistema.controller;

import java.util.List;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ort.sistema.model.Ticket;
import ort.sistema.repository.TicketRepository;

@RestController 
@RequestMapping("/api/tickets")

public class TicketController {
    private final TicketRepository repository;

        public TicketController(TicketRepository repository){
            this.repository = repository;
        }
    

        @GetMapping("/{id}") 
        public ResponseEntity<Ticket> obtenerPorId(@PathVariable Long id){
            return repository.findById(id)
                    .map(ticket -> ResponseEntity.ok(ticket))
                    .orElse(ResponseEntity.notFound().build());
        }

        @GetMapping
        public List<Ticket>obtenerTodos(){
            return repository.findAll();
        }


        @PostMapping
        public Ticket crear(@RequestBody Ticket ticket){
            return repository.save(ticket);
        } 


        @DeleteMapping("/{id}")
        public ResponseEntity<Void>eliminar(@PathVariable Long id){
            if(!repository.existsById(id)){
               return  ResponseEntity.notFound().build();
            }
        
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        
        }

}

package com.yuziio.helpdesk.controller;

import com.yuziio.helpdesk.model.Ticket;
import com.yuziio.helpdesk.repository.ChamadosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "*")
public class TicketController {


    @Autowired
    private ChamadosRepositorio chamadosRepositorio;

    @PostMapping
    public ResponseEntity<String> criarTicket(@RequestBody Ticket ticket) {
        try {
            chamadosRepositorio.save(ticket);
            System.out.println("Ticket salvo no MongoDB: " + ticket);
            return ResponseEntity.ok("Ticket recebido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao salvar ticket: " + e.getMessage());

        }
    }
}
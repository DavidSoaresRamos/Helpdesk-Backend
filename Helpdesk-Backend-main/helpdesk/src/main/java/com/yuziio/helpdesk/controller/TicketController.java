package com.yuziio.helpdesk.controller;

import com.yuziio.helpdesk.model.Ticket;
import com.yuziio.helpdesk.repository.ChamadosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController /* Permite a classe responder a requisições HTTP */
@RequestMapping("/tickets") /* Define uma rota */
@CrossOrigin(origins = "*")  /* Permite qualquer frontend se conectar com esse backend */
public class TicketController {


    @Autowired
    private ChamadosRepositorio chamadosRepositorio; /* Responsavel por salvar os dados no banco de dados */

    @PostMapping
    public ResponseEntity<String> criarTicket(@RequestBody Ticket ticket) { /* Converte o JSON para um objeto Ticket */
        try {
            chamadosRepositorio.save(ticket); /* Salva o objeto Ticket que foi convertido no banco de dados */
            System.out.println("Ticket salvo no MongoDB: " + ticket); /* log de confirmação */
            return ResponseEntity.ok("Ticket recebido com sucesso!"); /* Resposta HTTP 200 em caso de sucesso no envio */
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao salvar ticket: " + e.getMessage());/* Reposta em carro de erro no envio*/

        }
    }
}
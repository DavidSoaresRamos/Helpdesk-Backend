package com.yuziio.helpdesk.repository;

import com.yuziio.helpdesk.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadosRepositorio extends MongoRepository<Ticket, String> {
}
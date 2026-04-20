package com.bruna.ticket_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruna.ticket_system.model.Evento;
import com.bruna.ticket_system.model.ingresso.Ingresso;

public interface EventoRepository extends JpaRepository<Evento, Long> {


}

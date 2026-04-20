package com.bruna.ticket_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruna.ticket_system.model.ingresso.Ingresso;


public interface IngressoRepository extends JpaRepository<Ingresso, Long> {

	Ingresso findByCodigo(Integer codigo);

	
	

}

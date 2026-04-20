package com.bruna.ticket_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruna.ticket_system.model.vendas.Vendas;


public interface VendasRepository extends JpaRepository<Vendas, Long>{

	Vendas findbyCpfProprietario(String cpfProprietario);

}

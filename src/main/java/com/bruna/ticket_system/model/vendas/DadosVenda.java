package com.bruna.ticket_system.model.vendas;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bruna.ticket_system.model.ingresso.Ingresso;
import com.bruna.ticket_system.model.usuario.Usuario;

public record DadosVenda(
		LocalDateTime dataCompra,  BigDecimal valor, Ingresso ingresso, Usuario usuario
	)  {

}

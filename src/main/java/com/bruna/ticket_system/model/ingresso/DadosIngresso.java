package com.bruna.ticket_system.model.ingresso;


import java.math.BigDecimal;

import com.bruna.ticket_system.model.Evento;
import com.bruna.ticket_system.model.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosIngresso( @JsonAlias ("código") Integer codigo,@JsonAlias ("quantidade") int quantidade,@JsonAlias("Valor") BigDecimal valor ,@JsonAlias ("Evento") Evento evento,@JsonAlias ("Usuário") Usuario usuario) {
	
	public DadosIngresso(Ingresso ingresso) {	
        this(ingresso.getCodigo(), ingresso.getQuantidade(), ingresso.getValor(), ingresso.getEvento(), ingresso.getUsuario() );
	}


}
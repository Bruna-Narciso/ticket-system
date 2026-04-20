package com.bruna.ticket_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bruna.ticket_system.model.DadosEvento;
import com.bruna.ticket_system.model.Evento;
import com.bruna.ticket_system.model.ingresso.DadosIngresso;
import com.bruna.ticket_system.model.ingresso.Ingresso;
import com.bruna.ticket_system.model.usuario.Usuario;
import com.bruna.ticket_system.repository.EventoRepository;
import com.bruna.ticket_system.repository.IngressoRepository;
import com.bruna.ticket_system.repository.UsuarioRepository;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/ingresso")
public class IngressoController {
	
	@Autowired
	IngressoRepository ingressoRepositorio;
	
	@Autowired
	UsuarioRepository usuarioRepositorio;
	
	@Autowired
	EventoRepository eventoRepositorio;
	
	public ResponseEntity<DadosIngresso> criarIngresso(@RequestBody @Valid DadosIngresso dados, Usuario usuario, Evento evento){
		
		if(this.ingressoRepositorio.findByCodigo(dados.codigo())!= null) return ResponseEntity.badRequest().build();
		Ingresso ingresso = new Ingresso(dados, evento, usuario);
		ingressoRepositorio.save(ingresso);
		
		return ResponseEntity.ok().build();
		
}


	
	
}

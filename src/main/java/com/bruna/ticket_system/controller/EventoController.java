package com.bruna.ticket_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.bruna.ticket_system.model.DadosEvento;
import com.bruna.ticket_system.model.Evento;
import com.bruna.ticket_system.model.ingresso.Ingresso;
import com.bruna.ticket_system.repository.EventoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	EventoRepository eventoRepositorio;

	
	@PostMapping
	public ResponseEntity<Evento> cadastrarEvento(@RequestBody DadosEvento dados){
		
		if(this.eventoRepositorio.findById(dados.Id()) != null) return ResponseEntity.badRequest().build();
		Evento evento = new Evento(dados);
		eventoRepositorio.save(evento);
			
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<?> atualizarEvento(@PathVariable Long Id , @RequestBody @Valid DadosEvento dados){
		
	    Evento evento = eventoRepositorio.findById(Id).orElseThrow(() -> new EntityNotFoundException());
	    evento.setNomeCantor(dados.nomeCantor());
	    evento.setLocal(dados.local());
	    evento.setNomeEmpresa(dados.nomeEmpresa());;
		evento.setData(dados.data());
		evento.setCadeira(dados.cadeira());
		evento.setSetor(dados.setor());
		eventoRepositorio.save(evento);
		
		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<?> apagarEvento(@PathVariable Long Id, @RequestBody DadosEvento dados){
		Evento evento =  eventoRepositorio.findById(Id).orElseThrow(()-> new EntityNotFoundException());
		eventoRepositorio.delete(evento);
		return ResponseEntity.ok().build();
	}
	
	
	
}
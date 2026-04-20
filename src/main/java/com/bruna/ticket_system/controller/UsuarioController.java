package com.bruna.ticket_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bruna.ticket_system.model.DadosEvento;
import com.bruna.ticket_system.model.ingresso.DadosIngresso;
import com.bruna.ticket_system.model.ingresso.Ingresso;
import com.bruna.ticket_system.model.usuario.DadosUsuario;
import com.bruna.ticket_system.model.usuario.Usuario;
import com.bruna.ticket_system.repository.EventoRepository;
import com.bruna.ticket_system.repository.IngressoRepository;
import com.bruna.ticket_system.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	IngressoRepository ingressoRepositorio;
	
	@Autowired
	UsuarioRepository usuarioRepositorio;
	
	@Autowired
	EventoRepository eventoRepositorio;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<DadosUsuario> cadastrarUsuario(@RequestBody @Valid DadosUsuario dados, UriComponentsBuilder uriBuilder){
		
		if(this.usuarioRepositorio.findByCpfProprietario(dados.cpfProprietario()) != null)return ResponseEntity.badRequest().build();
	    Usuario usuario =  new Usuario(dados.nomeProprietario(), dados.cpfProprietario(), dados.email(),dados.idade() ,dados.numeroCelular());
	    this.usuarioRepositorio.save(usuario);
	    
		return ResponseEntity.ok().build();
	    
	}
	
	
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarUsuario(@PathVariable String cpfProprietario, @RequestBody @Valid DadosUsuario dados){
		
		Usuario usuario =  usuarioRepositorio.findByCpfProprietario(cpfProprietario);
		usuario.setNomeProprietario(dados.nomeProprietario());
		usuario.setEmail(dados.email());
		usuario.setIdade(dados.idade());
		usuario.setNumeroCelular(dados.numeroCelular());
		usuarioRepositorio.save(usuario);
		
		return ResponseEntity.ok().build();
			    
	}
	

}

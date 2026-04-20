package com.bruna.ticket_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruna.ticket_system.model.Evento;
import com.bruna.ticket_system.model.ingresso.Ingresso;
import com.bruna.ticket_system.model.usuario.Usuario;
import com.bruna.ticket_system.model.vendas.DadosVenda;
import com.bruna.ticket_system.model.vendas.Vendas;
import com.bruna.ticket_system.repository.EventoRepository;
import com.bruna.ticket_system.repository.IngressoRepository;
import com.bruna.ticket_system.repository.UsuarioRepository;
import com.bruna.ticket_system.repository.VendasRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;

@Entity
@RestController
@RequestMapping("/venda")
public class VendasController {
	
	@Autowired
	IngressoRepository ingressoRepositorio;
	
	@Autowired
	UsuarioRepository usuarioRepositorio;
	
	@Autowired
    VendasRepository vendasRepositorio;
	
	@PostMapping("/comprar")
	ResponseEntity<?> comprasCadastro(@PathVariable String cpfProprietario, @PathVariable Integer codigo, @PathVariable Long Id ,DadosVenda dados, Ingresso ingresso, Usuario usuario){
		
	   if (this.usuarioRepositorio.findByCpfProprietario(cpfProprietario)== null) return ResponseEntity.badRequest().build();
	   if (this.ingressoRepositorio.findByCodigo(codigo)== null) return ResponseEntity.badRequest().build();


	   if(usuarioRepositorio.findByCpfProprietario(cpfProprietario).equals(vendasRepositorio.findbyCpfProprietario(cpfProprietario)));
		Vendas vendas = new Vendas(dados, usuario, ingresso);
		vendasRepositorio.save(vendas);
		
		return ResponseEntity.ok().build();
	}
	
	
    @PutMapping("/atualizarCompras")
	ResponseEntity<?> atualizarcomprar(@PathVariable String cpfProprietario, @PathVariable Long Id , DadosVenda dados, Ingresso ingresso, Usuario usuario){
		
		Vendas vendas = vendasRepositorio.findById(Id).orElseThrow(()-> new EntityNotFoundException());
		vendas.setUsuario(usuario);
		vendas.setIngresso(ingresso);
		
	    return ResponseEntity.ok().build();

		
		
	}
    
    ResponseEntity<?> mostrarCompras(@PathVariable String cpfProprietario, @PathVariable Long Id, DadosVenda dados, Ingresso ingresso){
    	Vendas  vendas = vendasRepositorio.findById(Id).orElseThrow(()-> new EntityNotFoundException());
    	System.out.println(vendas);
    	
		return ResponseEntity.ok(vendas);
		}
    

}

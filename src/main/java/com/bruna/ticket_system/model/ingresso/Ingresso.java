package com.bruna.ticket_system.model.ingresso;

import java.math.BigDecimal;

import com.bruna.ticket_system.model.Evento;
import com.bruna.ticket_system.model.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "ingresso")
public class Ingresso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	Integer codigo;
	
	int quantidade;
	
	BigDecimal valor;
	
	@OneToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	
	public Ingresso(DadosIngresso dados, Evento evento, Usuario usuario) {
		this.valor =  dados.valor();
		this.quantidade = dados.quantidade();
	    this.codigo = dados.codigo();
	    this.evento = evento;
	    this.usuario = usuario;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Evento getEvento() {
		return evento;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return "Ingresso [id=" + id + ", codigo=" + codigo + ", quantidade=" + quantidade + ", valor=" + valor
				+ ", evento=" + evento + ", usuario=" + usuario + "]";
	}


	


	
	
}
	
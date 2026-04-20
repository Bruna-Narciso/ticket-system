package com.bruna.ticket_system.model.vendas;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bruna.ticket_system.model.ingresso.Ingresso;
import com.bruna.ticket_system.model.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vendas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private LocalDateTime dataCompra;

    private BigDecimal valor;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Ingresso ingresso;

	public Vendas(DadosVenda dados, Usuario usuario, Ingresso ingresso) {
		this.dataCompra = LocalDateTime.now();
		this.valor = dados.valor();
		this.usuario = usuario;
		this.ingresso = ingresso;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	@Override
	public String toString() {
		return "Vendas [id=" + id + ", dataCompra=" + dataCompra + ", valor=" + valor + ", usuario=" + usuario
				+ ", ingresso=" + ingresso + "]";
	}


	
}

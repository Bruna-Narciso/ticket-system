package com.bruna.ticket_system.model;

import java.time.LocalDateTime;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column (unique = true)
	String nomeCantor;
	String local;
	String nomeEmpresa;
	LocalDateTime data;
	String setor;
	String cadeira;
	
	
	
	
	public Evento(DadosEvento dados) {
		this.Id = dados.Id();
		this.nomeCantor = dados.nomeCantor();
		this.local = dados.local();
		this.nomeEmpresa = dados.nomeEmpresa();
		this.data = dados.data();
		this.setor = dados.setor();
		this.cadeira =  dados.cadeira();
	
	
	
	}
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNomeCantor() {
		return nomeCantor;
	}
	public void setNomeCantor(String nomeCantor) {
		this.nomeCantor = nomeCantor;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public String getSetor() {
		return setor;
	}


	public void setSetor(String setor) {
		this.setor = setor;
	}


	public String getCadeira() {
		return cadeira;
	}


	public void setCadeira(String cadeira) {
		this.cadeira = cadeira;
	}


	@Override
	public String toString() {
		return "Evento [Id=" + Id + ", nomeCantor=" + nomeCantor + ", local=" + local + ", nomeEmpresa=" + nomeEmpresa
				+ ", data=" + data + ", setor=" + setor + ", cadeira=" + cadeira + "]";
	}
	

	
	
	
}

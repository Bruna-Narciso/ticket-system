package com.bruna.ticket_system.model.usuario;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Id;


@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	String nomeProprietario;
	@Column(unique = true)
	String cpfProprietario;
	String email;
	int idade;
	String numeroCelular;
	
	
	public Usuario(DadosUsuario dados) {
		this.nomeProprietario = dados.nomeProprietario();
		this.cpfProprietario = dados.cpfProprietario();
		this.email = dados.email();
		this.idade = dados.idade();
		this.numeroCelular = dados.numeroCelular();
	
	}






	public Usuario(@NotBlank String nomeProprietario2, @NotBlank String cpfProprietario2,
			@NotBlank @Email String email2, @NotBlank int idade2, @NotBlank String numeroCelular2) {
		// TODO Auto-generated constructor stub
	}





	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getCpfProprietario() {
		return cpfProprietario;
	}

	public void setCpfProprietario(String cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", nomeProprietario=" + nomeProprietario + ", cpfProprietario=" + cpfProprietario
				+ ", email=" + email + ", idade=" + idade + ", numeroCelular=" + numeroCelular + "]";
	}

	

	

	
	
	
	
}


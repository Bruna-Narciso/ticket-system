package com.bruna.ticket_system.model.usuario;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosUsuario(@NotBlank String nomeProprietario,@NotBlank @CPF String cpfProprietario,@NotBlank @Email String email,@NotBlank int idade,@NotBlank String numeroCelular) {

}

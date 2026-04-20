package com.bruna.ticket_system.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record DadosEvento(@NotBlank Long Id, @NotBlank String nomeCantor, @NotBlank String local, @NotBlank String nomeEmpresa, @NotBlank LocalDateTime data, @NotBlank String setor,@NotBlank String cadeira) {

}                                                 
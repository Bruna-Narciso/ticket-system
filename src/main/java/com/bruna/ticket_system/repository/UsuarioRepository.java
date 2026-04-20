package com.bruna.ticket_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruna.ticket_system.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   Usuario findByCpfProprietario (String cpf);

//boolean findByCpfProprietaria(boolean b);

}

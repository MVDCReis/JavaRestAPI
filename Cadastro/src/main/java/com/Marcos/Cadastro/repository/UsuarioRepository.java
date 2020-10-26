package com.Marcos.Cadastro.repository;

import java.util.Optional;

import org.jboss.jandex.TypeTarget.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;

import com.Marcos.Cadastro.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
}

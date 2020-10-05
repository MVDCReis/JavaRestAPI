package com.Marcos.Cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Marcos.Cadastro.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNome(String nomeCurso);

}

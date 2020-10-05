package com.Marcos.Cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Marcos.Cadastro.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
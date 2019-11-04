package br.com.alura.forum.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	                   // curso é o nome do atributo de relacionamento e nome é o atributo dentro da entidade curso 
	                   // Se dentro de topic existir a propriedade nomeCurso é preciso definir o nome do método para
	                   // findByCurso_Nome
	List<Topico> findByCursoNome(String nomeCurso);

	// Se quiser usar uma nome diferente para método é preciso seguir a abordagem abaixo 
	// explicação video Springboot 1 Spring Boot Spring Boot Parte 1 Aula 3 - Atividade 8 Consulta com filtro.mp4	
	@Query("select t from Topico t where t.curso.nome = :nomeCurso") 
	List<Topico> carregarPorNomeCurso(@Param("nomeCurso") String nomeCurso);
	
	
	
	
	
}

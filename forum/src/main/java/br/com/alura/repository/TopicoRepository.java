package br.com.alura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNome(String cursoNome);
	
	@Query("select t from Topico where curso.nome = : cursoNome ")
	List<Topico> buscarTopicoPorNomeCurso(@Param("cursoNome") String cursoNome);
	
}

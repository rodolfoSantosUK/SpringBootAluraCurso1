package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.controller.repository.CursoRepository;
import br.com.alura.forum.controller.repository.TopicoRepository;
import br.com.alura.forum.modelo.Topico;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		
		if( nomeCurso == null) {
		
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);

		} else {

			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
			
		}
	 
	}
	
	@PostMapping  /* Quando usamos post devemos usar a anotação  @RequestBody
	                 quando é get o parametro é passado na url  
	                 mas se tratando de post precisamos avisar o Spring que será
	                 passado um parâmetro no corpo da requisição */
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm form,
			                                   UriComponentsBuilder uriBuilder ) {
		Topico topico =  form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI  uri =  uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
	    return ResponseEntity.created(uri).body(new TopicoDto(topico));
		
	}
	
	
	
	

}
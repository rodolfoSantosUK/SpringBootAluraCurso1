package br.com.alura.forum.controller.form;

import br.com.alura.forum.controller.repository.TopicoRepository;
import br.com.alura.forum.modelo.Topico;

public class AtualizacaoTopicoForm {

	private String titulo;

	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public AtualizacaoTopicoForm() {
		super();
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {

		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		return topico;
	}

}

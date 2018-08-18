package com.algaworks.algamoneyapi.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.event.RecursoCriadoEvent;
import com.algaworks.algamoneyapi.exceptionhandler.AlgamoneyExceptionHandler.Erro;
import com.algaworks.algamoneyapi.exceptionhandler.PessoaInexistenteOuInativaException;
import com.algaworks.algamoneyapi.model.Lancamento;
import com.algaworks.algamoneyapi.repository.LancamentoFilter;
import com.algaworks.algamoneyapi.repository.LancamentoRepository;
import com.algaworks.algamoneyapi.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository repository;
	
	@Autowired
	private LancamentoService service;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
//	@GetMapping
//	public Page<Lancamento> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable){
//		return repository.filtrar(lancamentoFilter, pageable);
//	}
	
	@GetMapping("/{codigo}")	
	public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo){
		Lancamento lancamento = service.buscarLancamentoPeloCodigo(codigo);
		return ResponseEntity.ok(lancamento);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long codigo) {
		//repository.delete(service.buscarLancamentoPeloCodigo(codigo));
		repository.delete(codigo);
	}
	
	@PostMapping
	public ResponseEntity<Lancamento> criar(@RequestBody Lancamento lancamento, HttpServletResponse response){
		Lancamento lancamentoSalvo = service.salvar(lancamento);
		//return (lancamentoSalvo != null ? ResponseEntity.ok(lancamento) : ResponseEntity.noContent().build());
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	@ExceptionHandler({PessoaInexistenteOuInativaException.class})
	public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException exception){
		String mensagem = messageSource.getMessage("pessoa.inexistente-ou-inativa", null, 
				LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = exception.toString();

		List<Erro> erros = Arrays.asList(new Erro(mensagem, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}
}

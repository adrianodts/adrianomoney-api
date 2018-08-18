package com.algaworks.algamoneyapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.event.RecursoCriadoEvent;
import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.PessoaRepository;
import com.algaworks.algamoneyapi.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	PessoaRepository repository;
	
	@Autowired
	PessoaService service;
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Pessoa> listar(){
		return repository.findAll();
	}
	
	@GetMapping("/{codigo}")	
	public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo){
		Pessoa pessoa = repository.findOne(codigo);
		return (pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build());
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = repository.save(pessoa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
	
	@DeleteMapping("/{codigo}")	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo, HttpServletResponse response){
		repository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")	
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(codigo, pessoa));
	}
	
	@PutMapping("/{codigo}/ativo")	
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		service.atualizarPessoaPorCodigo(codigo, ativo);
	}
}

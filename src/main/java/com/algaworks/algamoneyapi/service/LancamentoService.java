package com.algaworks.algamoneyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.exceptionhandler.PessoaInexistenteOuInativaException;
import com.algaworks.algamoneyapi.model.Lancamento;
import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.LancamentoRepository;
import com.algaworks.algamoneyapi.repository.PessoaRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	
	public Lancamento buscarLancamentoPeloCodigo(Long codigo) {
		Lancamento lancamento = lancamentoRepository.findOne(codigo);
		
		if(lancamento == null)
			throw new EmptyResultDataAccessException(1);
		
		return lancamento;
	}

	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		
		if(pessoa == null || pessoa.isInativo())
			throw new PessoaInexistenteOuInativaException();
		
		return lancamentoRepository.save(lancamento);
	}
	
	
}

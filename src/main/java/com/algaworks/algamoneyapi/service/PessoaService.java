package com.algaworks.algamoneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repository;
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");	
		return repository.save(pessoaSalva);	
	}
	
	public void atualizarPessoaPorCodigo(Long codigo, Boolean ativo  ) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		repository.save(pessoaSalva);
	}
	
	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		Pessoa pessoa = repository.findOne(codigo);
		
		if(pessoa == null)
			throw new EmptyResultDataAccessException(1);
		
		return pessoa;
	}
}

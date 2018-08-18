package com.algaworks.algamoneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.model.Categoria;
import com.algaworks.algamoneyapi.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalva = buscarCategoriaPeloCodigo(codigo);		
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
		return repository.save(categoriaSalva);	
	}
	
//	public void atualizarPropriedadeAtivo(Long codigo, boolean ativo) {
//		Categoria categoria = buscarCategoriaPeloCodigo(codigo);		
//	}
	
	public Categoria buscarCategoriaPeloCodigo(Long codigo) {
		Categoria categoria = repository.findOne(codigo);
		
		if(categoria == null)
			throw new EmptyResultDataAccessException(1);
		
		return categoria;
	}
}

package br.edu.ifpb.mt.dac.nn.service.impl;

import java.util.List;

import br.edu.ifpb.mt.dac.nn.dao.GenericDAO;
import br.edu.ifpb.mt.dac.nn.service.GenericService;

public class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

	protected GenericDAO<T, ID> dao;
	
	@Override
	public void salvar(T entidade) {
		dao.salvar(entidade);
	}

	@Override
	public T atualizar(T entidade) {
		return dao.atualizar(entidade);
	}

	@Override
	public void deletar(T entidade) {
		dao.deletar(entidade);
	}

	@Override
	public T buscarPorID(ID id) {
		return dao.buscarPorID(id);
	}

	@Override
	public List<T> buscarTodos() {
		return dao.buscarTodos();
	}
	
}
package br.edu.ifpb.mt.dac.nn.services.impl;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.mt.dac.nn.dao.ContaDAO;
import br.edu.ifpb.mt.dac.nn.dao.impl.ContaDaoImpl;
import br.edu.ifpb.mt.dac.nn.enumerations.TipoUsuario;
import br.edu.ifpb.mt.dac.nn.exceptions.NegocioNordesteException;
import br.edu.ifpb.mt.dac.nn.model.Conta;
import br.edu.ifpb.mt.dac.nn.services.ContaService;
import br.edu.ifpb.mt.dac.nn.util.jpa.Transactional;

public class ContaServiceImpl extends GenericServiceImpl<Conta, Long> implements ContaService {

	private static final long serialVersionUID = 18654878732134577L;

	public ContaServiceImpl() {
	}

	@Inject
	public ContaServiceImpl(ContaDAO contaDAO) {
		this.dao = contaDAO;
	}
	
	@Override
	@Transactional
	public void salvar(Conta entidade) throws NegocioNordesteException {
		ContaDAO contaDAO = (ContaDAO) this.dao;
		
		Conta contaUsername = contaDAO.buscarPorUsername(entidade.getUsername());
		Conta contaEmail = contaDAO.buscarPorEmail(entidade.getEmail());
		
		if(contaUsername != null) {
			throw new NegocioNordesteException("Já existe um anunciante com este username cadastrado.");
		}
		
		if(contaEmail != null) {
			throw new NegocioNordesteException("Já existe um anunciante com este username cadastrado.");
		}
		
		contaDAO.salvar(entidade);
	}

	@Override
	public List<Conta> buscarPorTipo(TipoUsuario tipo) {
		
		return null;
	}

	@Override
	public Conta buscarPorEmail(String email) {
		return null;
	}

	@Override
	public Conta buscarPorUsername(String username) {
		ContaDAO contaDAO = (ContaDAO) this.dao;
		
		return contaDAO.buscarPorUsername(username);
	}

}
package br.com.varejo.facade.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.varejo.dao.ClienteDAO;
import br.com.varejo.exception.BusinessException;
import br.com.varejo.facade.ClienteFacade;
import br.com.varejo.vo.ClienteVO;

@Service
public class ClienteFacadeImpl implements ClienteFacade{

	@Autowired
	private ClienteDAO dao;
	
	/**
	 * {@inheritDoc}
	 */
	public void incluir(ClienteVO vo) throws SQLException, BusinessException{
		
		if (dao.contar(vo.getIdCliente(), vo.getCpf().replaceAll("[.-]", ""), "cpf") > 0){
			throw new BusinessException(" CPF já cadastrado.");
		}
		else if (dao.contar(vo.getIdCliente(), vo.getEmail(), "email") > 0){
			throw new BusinessException(" Email já cadastrado.");
		}
		else{
			dao.incluir(vo);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void atualizar(ClienteVO vo) throws SQLException, BusinessException{
		
		if (dao.contar(vo.getIdCliente(), vo.getCpf().replaceAll("[.-]", ""), "cpf") > 0){
			throw new BusinessException(" CPF já cadastrado.");
		}
		else if (dao.contar(vo.getIdCliente(), vo.getEmail(), "email") > 0){
			throw new BusinessException(" Email já cadastrado.");
		}
		else{
			dao.atualizar(vo);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<ClienteVO> listar() throws SQLException{
		return dao.listar();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void excluir(ClienteVO vo) throws SQLException, BusinessException{
		
		if (dao.verificarClienteVenda(vo) > 0){
			throw new BusinessException(" Existem vendas vinculadas a ele.");
		}
		else{
			dao.excluir(vo);
		}
	}
	
}

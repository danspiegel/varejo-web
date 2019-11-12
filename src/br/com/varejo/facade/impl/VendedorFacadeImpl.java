package br.com.varejo.facade.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.varejo.dao.VendedorDAO;
import br.com.varejo.exception.BusinessException;
import br.com.varejo.facade.VendedorFacade;
import br.com.varejo.vo.VendedorVO;

@Service
public class VendedorFacadeImpl implements VendedorFacade{

	@Autowired
	private VendedorDAO dao;
	
	/**
	 * {@inheritDoc}
	 */
	public boolean validarDados(VendedorVO vo) throws SQLException{
		return dao.validarDados(vo);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void incluir(VendedorVO vo) throws SQLException, BusinessException{
		
		if (dao.contar(vo.getIdVendedor(), vo.getCpf().replaceAll("[.-]", ""), "cpf") > 0){
			throw new BusinessException(" CPF já cadastrado.");
		}
		else if (dao.contar(vo.getIdVendedor(), vo.getEmail(), "email") > 0){
			throw new BusinessException(" Email já cadastrado.");
		}
		else if (dao.contar(vo.getIdVendedor(), vo.getLogin(), "login") > 0){
			throw new BusinessException(" Usuário já cadastrado.");
		}
		else{
			dao.incluir(vo);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int atualizar(VendedorVO vo) throws SQLException, BusinessException{
		
		if (dao.contar(vo.getIdVendedor(), vo.getCpf().replaceAll("[.-]", ""), "cpf") > 0){
			throw new BusinessException(" CPF já cadastrado.");
		}
		else if (dao.contar(vo.getIdVendedor(), vo.getEmail(), "email") > 0){
			throw new BusinessException(" Email já cadastrado.");
		}
		else{
			return dao.atualizar(vo);
		}
	}
	
}

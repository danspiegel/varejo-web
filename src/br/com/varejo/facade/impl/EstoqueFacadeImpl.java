package br.com.varejo.facade.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.varejo.dao.EstoqueDAO;
import br.com.varejo.exception.BusinessException;
import br.com.varejo.facade.EstoqueFacade;
import br.com.varejo.vo.EstoqueVO;

@Service
public class EstoqueFacadeImpl implements EstoqueFacade {

	@Autowired
	private EstoqueDAO dao;
	
	/**
	 * {@inheritDoc}
	 */
	public void incluir(EstoqueVO vo) throws SQLException{
		dao.incluir(vo);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void atualizar(EstoqueVO vo) throws SQLException{
		
		if (dao.verificarEspaco(vo.getIdEstoque(), 0) > 0){
			vo.setSituacao("LIVRE");
		}
		else{
			vo.setSituacao("LOTADO");
		}
		
		dao.atualizar(vo);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<EstoqueVO> listar(int obj, int idProduto) throws SQLException{
		return dao.listar(obj, idProduto);
	}
	
	/**
	 * {@inheritDoc}
	 * @throws BusinessException 
	 */
	public void excluir(EstoqueVO vo) throws SQLException, BusinessException{
			
		if (dao.verificarProdutoEstoque(vo) > 0){
			throw new BusinessException(" Existem produtos vinculados a ele.");
		}
		else{
			dao.excluir(vo);
		}
		
	}
	
}

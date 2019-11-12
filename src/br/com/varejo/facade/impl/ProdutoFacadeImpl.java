package br.com.varejo.facade.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.varejo.dao.EstoqueDAO;
import br.com.varejo.dao.ProdutoDAO;
import br.com.varejo.exception.BusinessException;
import br.com.varejo.facade.ProdutoFacade;
import br.com.varejo.vo.EstoqueVO;
import br.com.varejo.vo.ProdutoVO;

@Service
public class ProdutoFacadeImpl implements ProdutoFacade {

	@Autowired
	private ProdutoDAO dao;
	
	@Autowired 
	EstoqueDAO estoqueDAO;
	
	EstoqueVO estoque = new EstoqueVO();
	
	/**
	 * {@inheritDoc}
	 */
	public void incluir(ProdutoVO vo) throws SQLException, BusinessException{
		
		int espaco = estoqueDAO.verificarEspaco(vo.getIdEstoque(), vo.getIdProduto());
		
		/*if (espaco >= vo.getUnidades()){
			dao.incluir(vo);
		}
		else{
			throw new BusinessException("Espaço insuficiente. Limite do estoque é "+ espaco +" unidade(s).");
		}*/
		
		estoque.setIdEstoque(vo.getIdEstoque());
		
		if (espaco > vo.getUnidades()){
			dao.incluir(vo);
			estoque.setSituacao("LIVRE");
			estoqueDAO.atualizar(estoque);
		}
		else if (espaco == vo.getUnidades()){
			dao.incluir(vo);
			estoque.setSituacao("LOTADO");
			estoqueDAO.atualizar(estoque);
		}
		else{
			throw new BusinessException(" Espaço insuficiente. Limite do estoque é "+ espaco +" unidade(s).");
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void atualizar(ProdutoVO vo) throws SQLException, BusinessException{
		
		int espaco = estoqueDAO.verificarEspaco(vo.getIdEstoque(), vo.getIdProduto());
		
		/*if (espaco >= vo.getUnidades()){
			dao.atualizar(vo);
		}
		else{
			throw new BusinessException("Espaço insuficiente. Limite do estoque é "+ espaco);
		}*/
		
		estoque.setIdEstoque(vo.getIdEstoque());
		
		if (espaco > vo.getUnidades()){
			dao.atualizar(vo);
			estoque.setSituacao("LIVRE");
			estoqueDAO.atualizar(estoque);
		}
		else if (espaco == vo.getUnidades()){
			dao.atualizar(vo);
			estoque.setSituacao("LOTADO");
			estoqueDAO.atualizar(estoque);
		}
		else{
			throw new BusinessException(" Espaço insuficiente. Limite do estoque é "+ espaco +" unidade(s).");
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void excluir(ProdutoVO vo) throws SQLException, BusinessException{
		
		estoque.setIdEstoque(vo.getIdEstoque());
		
		if (dao.verificarProdutoVenda(vo) > 0){
			throw new BusinessException(" Existem vendas vinculadas a ele.");
		}
		else{
			dao.excluir(vo);
			estoque.setSituacao("LIVRE");
			estoqueDAO.atualizar(estoque);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<ProdutoVO> listar(int obj) throws SQLException{
		return dao.listar(obj);
	}
	
}

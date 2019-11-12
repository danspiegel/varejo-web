package br.com.varejo.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.vo.ProdutoVO;

public interface ProdutoFacade {
	
	/**
	 * Método responsável por chamar o DAO de incluir produto após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public void incluir(ProdutoVO vo) throws SQLException, BusinessException;
	
	/**
	 * Método responsável por chamar o DAO de atualizar produto após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public void atualizar(ProdutoVO vo) throws SQLException, BusinessException;
	
	/**
	 * Método responsável por chamar o DAO de excluir produto após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException 
	 */
	public void excluir(ProdutoVO vo) throws SQLException, BusinessException;
	
	/**
	 * Método responsável por chamar o DAO de listar produtos após a validação da regra de negócio.
	 * 
	 * @param obj
	 * @return List<ProdutoVO>
	 * @throws SQLException
	 */
	public List<ProdutoVO> listar(int obj) throws SQLException;
	
}

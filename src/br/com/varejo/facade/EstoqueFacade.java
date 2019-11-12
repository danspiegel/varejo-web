package br.com.varejo.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.vo.EstoqueVO;

public interface EstoqueFacade {
	
	/**
	 * Método responsável por chamar o DAO de incluir estoque após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void incluir(EstoqueVO vo) throws SQLException;
	
	/**
	 * Método responsável por chamar o DAO de atualizar o estoque após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void atualizar(EstoqueVO vo) throws SQLException;
	
	/**
	 * Método responsável por chamar o DAO de listar estoques após a validação da regra de negócio.
	 * 
	 * @param obj
	 * @return List<EstoqueVO>
	 * @throws SQLException
	 */
	public List<EstoqueVO> listar(int obj, int idProduto) throws SQLException;
	
	/**
	 * Método responsável por chamar o DAO de excluir estoque após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException 
	 */
	public void excluir(EstoqueVO vo) throws SQLException, BusinessException;
	
}

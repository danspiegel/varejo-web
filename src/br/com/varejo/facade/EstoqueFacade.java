package br.com.varejo.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.vo.EstoqueVO;

public interface EstoqueFacade {
	
	/**
	 * M�todo respons�vel por chamar o DAO de incluir estoque ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void incluir(EstoqueVO vo) throws SQLException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de atualizar o estoque ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void atualizar(EstoqueVO vo) throws SQLException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de listar estoques ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param obj
	 * @return List<EstoqueVO>
	 * @throws SQLException
	 */
	public List<EstoqueVO> listar(int obj, int idProduto) throws SQLException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de excluir estoque ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException 
	 */
	public void excluir(EstoqueVO vo) throws SQLException, BusinessException;
	
}

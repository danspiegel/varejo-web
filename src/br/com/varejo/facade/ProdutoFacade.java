package br.com.varejo.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.vo.ProdutoVO;

public interface ProdutoFacade {
	
	/**
	 * M�todo respons�vel por chamar o DAO de incluir produto ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public void incluir(ProdutoVO vo) throws SQLException, BusinessException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de atualizar produto ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public void atualizar(ProdutoVO vo) throws SQLException, BusinessException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de excluir produto ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException 
	 */
	public void excluir(ProdutoVO vo) throws SQLException, BusinessException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de listar produtos ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param obj
	 * @return List<ProdutoVO>
	 * @throws SQLException
	 */
	public List<ProdutoVO> listar(int obj) throws SQLException;
	
}

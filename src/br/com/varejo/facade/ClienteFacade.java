package br.com.varejo.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.vo.ClienteVO;

public interface ClienteFacade {
	
	/**
	 * M�todo respons�vel por chamar o DAO de incluir cliente ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public void incluir(ClienteVO vo) throws SQLException, BusinessException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de atualizar cliente ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public void atualizar(ClienteVO vo) throws SQLException, BusinessException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de listar clientes ap�s a valida��o da regra de neg�cio.
	 * 
	 * @return List<ClienteVO>
	 * @throws SQLException
	 */
	public List<ClienteVO> listar() throws SQLException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de excluir cliente ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException 
	 */
	public void excluir(ClienteVO vo) throws SQLException, BusinessException;
}

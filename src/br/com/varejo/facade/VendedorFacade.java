package br.com.varejo.facade;

import java.sql.SQLException;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.vo.VendedorVO;

public interface VendedorFacade {

	/**
	 * M�todo respons�vel por chamar o DAO de validar dados do vendedor ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean validarDados(VendedorVO vo) throws SQLException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de incluir vendedor ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public void incluir(VendedorVO vo) throws SQLException, BusinessException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de atualizar vendedor ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @return int
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public int atualizar(VendedorVO vo) throws SQLException, BusinessException;
	
}

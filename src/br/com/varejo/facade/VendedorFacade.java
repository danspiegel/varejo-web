package br.com.varejo.facade;

import java.sql.SQLException;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.vo.VendedorVO;

public interface VendedorFacade {

	/**
	 * Método responsável por chamar o DAO de validar dados do vendedor após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean validarDados(VendedorVO vo) throws SQLException;
	
	/**
	 * Método responsável por chamar o DAO de incluir vendedor após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public void incluir(VendedorVO vo) throws SQLException, BusinessException;
	
	/**
	 * Método responsável por chamar o DAO de atualizar vendedor após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @return int
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public int atualizar(VendedorVO vo) throws SQLException, BusinessException;
	
}

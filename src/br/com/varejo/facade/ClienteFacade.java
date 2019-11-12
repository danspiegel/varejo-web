package br.com.varejo.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.vo.ClienteVO;

public interface ClienteFacade {
	
	/**
	 * Método responsável por chamar o DAO de incluir cliente após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public void incluir(ClienteVO vo) throws SQLException, BusinessException;
	
	/**
	 * Método responsável por chamar o DAO de atualizar cliente após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public void atualizar(ClienteVO vo) throws SQLException, BusinessException;
	
	/**
	 * Método responsável por chamar o DAO de listar clientes após a validação da regra de negócio.
	 * 
	 * @return List<ClienteVO>
	 * @throws SQLException
	 */
	public List<ClienteVO> listar() throws SQLException;
	
	/**
	 * Método responsável por chamar o DAO de excluir cliente após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 * @throws BusinessException 
	 */
	public void excluir(ClienteVO vo) throws SQLException, BusinessException;
}

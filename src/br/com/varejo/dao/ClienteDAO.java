package br.com.varejo.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.vo.ClienteVO;

public interface ClienteDAO {
	
	/**
	 * Método responsável por incluir os dados do cliente.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void incluir(ClienteVO vo) throws SQLException;
	
	/**
	 * Método responsável por atualizar os dados do cliente.
	 * @param vo
	 * @throws SQLException
	 */
	public void atualizar(ClienteVO vo) throws SQLException;
	
	/**
	 * Método responsável por realizar a contagem do cliente de acordo com os parametros passados.
	 * 
	 * @param id
	 * @param valor
	 * @param campo
	 * @return Integer
	 * @throws SQLException
	 */
	public Integer contar(Integer id, String valor, String campo) throws SQLException;
	
	/**
	 * Método responsável por listar todos os clientes.
	 * 
	 * @return List<ClienteVO>
	 * @throws SQLException
	 */
	public List<ClienteVO> listar() throws SQLException;
	
	/**
	 * Método responsável por excluir os dados do cliente.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void excluir(ClienteVO vo) throws SQLException;
	
	/**
	 * Método responsável por verificar se o cliente está vinculado em alguma venda.
	 * 
	 * @param vo
	 * @return Integer
	 * @throws SQLException
	 */
	public Integer verificarClienteVenda(ClienteVO vo) throws SQLException;
	
}

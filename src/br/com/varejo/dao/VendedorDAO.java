package br.com.varejo.dao;

import java.sql.SQLException;

import br.com.varejo.vo.VendedorVO;

public interface VendedorDAO {
	
	/**
	 * Método responsável por validar se os dados do vendedor estão corretos.
	 * 
	 * @param vo
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean validarDados(VendedorVO vo) throws SQLException;
	
	/**
	 * Método responsável por contar os vendedores de acordo com os parametros passados.
	 * 
	 * @param id
	 * @param valor
	 * @param campo
	 * @return Integer
	 * @throws SQLException
	 */
	public Integer contar(Integer id, String valor, String campo) throws SQLException;
	
	/**
	 * Método responsável por incluir os dados do vendedor.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void incluir(VendedorVO vo) throws SQLException;
	
	/**
	 * Método responsável por atualizar os dados do vendedor.
	 * 
	 * @param vo
	 * @return int
	 * @throws SQLException
	 */
	public int atualizar(VendedorVO vo) throws SQLException;
	
}

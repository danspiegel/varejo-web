package br.com.varejo.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.vo.VendaVO;

public interface VendaDAO {
	
	/**
	 * Método responsável por incluir os dados da venda.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void incluir(VendaVO vo) throws SQLException;
	
	/**
	 * Método responsável por listar as vendas do vendedor logado.
	 * 
	 * @param vendedor
	 * @return List<VendaVO>
	 * @throws SQLException
	 */
	public List<VendaVO> listar(int vendedor) throws SQLException;
	
}

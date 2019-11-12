package br.com.varejo.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.vo.VendaVO;

public interface VendaFacade {

	/**
	 * M�todo respons�vel por chamar o DAO de incluir venda ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void incluir(VendaVO vo) throws SQLException;
	
	/**
	 * M�todo respons�vel por chamar o DAO de listar vendas ap�s a valida��o da regra de neg�cio.
	 * 
	 * @param vendedor
	 * @return List<VendaVO>
	 * @throws SQLException
	 */
	public List<VendaVO> listar(int vendedor) throws SQLException;
	
}

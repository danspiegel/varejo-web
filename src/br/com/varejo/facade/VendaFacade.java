package br.com.varejo.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.vo.VendaVO;

public interface VendaFacade {

	/**
	 * Método responsável por chamar o DAO de incluir venda após a validação da regra de negócio.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void incluir(VendaVO vo) throws SQLException;
	
	/**
	 * Método responsável por chamar o DAO de listar vendas após a validação da regra de negócio.
	 * 
	 * @param vendedor
	 * @return List<VendaVO>
	 * @throws SQLException
	 */
	public List<VendaVO> listar(int vendedor) throws SQLException;
	
}

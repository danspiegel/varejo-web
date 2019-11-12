package br.com.varejo.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.vo.ProdutoVO;

public interface ProdutoDAO {
	
	/**
	 * M�todo respons�vel por incluir os dados do produto.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void incluir(ProdutoVO vo) throws SQLException;
	
	/**
	 * M�todo respons�vel por atualizar os dados do produto.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void atualizar(ProdutoVO vo) throws SQLException;
	
	/**
	 * M�todo respons�vel por excluir os dados do estoque.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void excluir(ProdutoVO vo) throws SQLException;
	
	/**
	 * M�todo respons�vel por listar os produtos de acordo com parametro passado.
	 * 
	 * @param obj
	 * @return List<ProdutoVO>
	 * @throws SQLException
	 */
	public List<ProdutoVO> listar(int obj) throws SQLException;
	
	/**
	 * M�todo respons�vel por verificar se existem vendas vinculadas ao produto.
	 * 
	 * @param vo
	 * @return Integer
	 * @throws SQLException
	 */
	public Integer verificarProdutoVenda(ProdutoVO vo) throws SQLException;
}

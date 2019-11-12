package br.com.varejo.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.vo.ProdutoVO;

public interface ProdutoDAO {
	
	/**
	 * Método responsável por incluir os dados do produto.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void incluir(ProdutoVO vo) throws SQLException;
	
	/**
	 * Método responsável por atualizar os dados do produto.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void atualizar(ProdutoVO vo) throws SQLException;
	
	/**
	 * Método responsável por excluir os dados do estoque.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void excluir(ProdutoVO vo) throws SQLException;
	
	/**
	 * Método responsável por listar os produtos de acordo com parametro passado.
	 * 
	 * @param obj
	 * @return List<ProdutoVO>
	 * @throws SQLException
	 */
	public List<ProdutoVO> listar(int obj) throws SQLException;
	
	/**
	 * Método responsável por verificar se existem vendas vinculadas ao produto.
	 * 
	 * @param vo
	 * @return Integer
	 * @throws SQLException
	 */
	public Integer verificarProdutoVenda(ProdutoVO vo) throws SQLException;
}

package br.com.varejo.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.varejo.vo.EstoqueVO;
import br.com.varejo.vo.ProdutoVO;

public interface EstoqueDAO {
	
	/**
	 * Método responsável por incluir os dados do estoque.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void incluir(EstoqueVO vo) throws SQLException;
	
	/**
	 * Método responsável por atualizar os dados do estoque.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void atualizar(EstoqueVO vo) throws SQLException;
	
	/**
	 * Método responsável por listar os estoques de acordo com o parametro passado.
	 * 
	 * @param obj
	 * @return List<EstoqueVO>
	 * @throws SQLException
	 */
	public List<EstoqueVO> listar(int obj, int idProduto) throws SQLException;
	
	/**
	 * Método responsável por excluir os dados do estoque.
	 * 
	 * @param vo
	 * @throws SQLException
	 */
	public void excluir(EstoqueVO vo) throws SQLException;
	
	/**
	 * Método responsável por verificar o espaço atual do estoque.
	 * 
	 * @param vo
	 * @return Integer
	 * @throws SQLException
	 */
	public Integer verificarEspaco(int idEstoque, int idProduto) throws SQLException;
	
	/**
	 * Método responsável por verificar se existem produtos vinculados ao estoque.
	 * 
	 * @param vo
	 * @return Integer
	 * @throws SQLException
	 */
	public Integer verificarProdutoEstoque(EstoqueVO vo) throws SQLException;
	
}

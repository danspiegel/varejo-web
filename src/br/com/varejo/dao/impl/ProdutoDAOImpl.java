package br.com.varejo.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.varejo.dao.ProdutoDAO;
import br.com.varejo.vo.ProdutoVO;

@Repository
public class ProdutoDAOImpl implements ProdutoDAO{
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * {@inheritDoc}
	 */
	public void incluir(ProdutoVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("descricao", vo.getDescricao());
			params.addValue("valor", vo.getValor());
			params.addValue("unidades", vo.getUnidades());
			params.addValue("id_estoque", vo.getIdEstoque());
			
			StringBuilder sqlProduto = new StringBuilder("INSERT INTO produtos (descricao, valor, unidades, id_estoque) ");
			sqlProduto.append(" VALUES (:descricao, :valor, :unidades, :id_estoque) ");
			
			StringBuilder sqlEstoque = new StringBuilder("UPDATE estoques SET totalunidades = totalunidades + :unidades WHERE id = :id_estoque");
			
			jdbcTemplate.update(sqlProduto.toString(), params);
			
			jdbcTemplate.update(sqlEstoque.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void atualizar(ProdutoVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", vo.getIdProduto());
			params.addValue("descricao", vo.getDescricao());
			params.addValue("valor", vo.getValor());
			params.addValue("unidades", vo.getUnidades());
			params.addValue("idEstoque", vo.getIdEstoque());
			
			StringBuilder sqlEstoquePre = new StringBuilder("UPDATE estoques SET totalunidades = totalunidades - (SELECT unidades FROM produtos WHERE id = :id) ");
			sqlEstoquePre.append("WHERE id = (SELECT id_estoque FROM produtos WHERE id = :id)");
			
			StringBuilder sqlProduto = new StringBuilder("UPDATE produtos SET descricao = :descricao, valor = :valor, unidades = :unidades, id_estoque = :idEstoque WHERE id = :id");
			
			StringBuilder sqlEstoquePos = new StringBuilder(" UPDATE estoques SET totalunidades = totalunidades + :unidades ");
			//sqlEstoquePos.append("WHERE id = (SELECT idEstoque FROM produtos WHERE id = :id)");
			sqlEstoquePos.append("WHERE id = :idEstoque ");
			
			jdbcTemplate.update(sqlEstoquePre.toString(), params);
			
			jdbcTemplate.update(sqlProduto.toString(), params);
				
			jdbcTemplate.update(sqlEstoquePos.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<ProdutoVO> listar(int obj) throws SQLException{
		
		try{
			
			StringBuilder sql = new StringBuilder(" SELECT id, descricao, valor, id_estoque, unidades FROM produtos ");
			
			if (obj != 0){
				sql.append(" WHERE unidades > 0 ");
			}
			
			sql.append(" ORDER BY id ");
			
			List<ProdutoVO> lista = new ArrayList<ProdutoVO>();
			List<Map<String,Object>> resultSet = jdbcTemplate.queryForList(sql.toString(), new MapSqlParameterSource());
			
			DecimalFormat df = new DecimalFormat("#0.00");
			
			for(Map resultado: resultSet){
				
				ProdutoVO vo = new ProdutoVO();
				
				vo.setIdProduto((int) resultado.get("id"));
				vo.setDescricao((String) resultado.get("descricao"));
				vo.setValor(BigDecimal.valueOf((Double) resultado.get("valor")));
				vo.setIdEstoque((int) resultado.get("id_estoque"));
				vo.setUnidades((int) resultado.get("unidades"));
				
				lista.add(vo);
				
			}
			
			return lista;
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void excluir(ProdutoVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", vo.getIdProduto());
			params.addValue("idEstoque", vo.getIdEstoque());
			
			StringBuilder sqlEstoque = new StringBuilder("UPDATE estoques SET totalunidades = totalunidades-(SELECT unidades FROM produtos WHERE id = :id) ");
			sqlEstoque.append("WHERE id = :idEstoque");
			
			StringBuilder sqlProduto = new StringBuilder("DELETE FROM produtos WHERE id = :id");
			
			jdbcTemplate.update(sqlEstoque.toString(), params);
			
			jdbcTemplate.update(sqlProduto.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Integer verificarProdutoVenda(ProdutoVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", vo.getIdProduto());
			
			StringBuilder sql = new StringBuilder("SELECT COUNT(p.id) FROM produtos p INNER JOIN produto_vendas pv ");
			sql.append(" ON (pv.id_produto = p.id) WHERE p.id = :id ");
			
			return jdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
	}
	
}

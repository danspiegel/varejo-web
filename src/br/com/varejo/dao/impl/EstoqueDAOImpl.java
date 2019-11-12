package br.com.varejo.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.varejo.dao.EstoqueDAO;
import br.com.varejo.vo.EstoqueVO;
import br.com.varejo.vo.ProdutoVO;

@Repository
public class EstoqueDAOImpl implements EstoqueDAO {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * {@inheritDoc}
	 */
	public void incluir(EstoqueVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("descricao", vo.getDescricao());
			params.addValue("tamanho", vo.getTamanho());
			params.addValue("situacao", "LIVRE");
			
			StringBuilder sql = new StringBuilder("INSERT INTO estoques (descricao, tamanho, situacao) VALUES (:descricao, :tamanho, :situacao)");
			
			jdbcTemplate.update(sql.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void atualizar(EstoqueVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", vo.getIdEstoque());
			params.addValue("descricao", vo.getDescricao());
			params.addValue("tamanho", vo.getTamanho());
			params.addValue("situacao", vo.getSituacao());
			
			/*if (vo.getTamanho() > vo.getTotalunidades()){
				params.addValue("situacao", "LIVRE");
			}
			else if (vo.getTamanho() == vo.getTotalunidades()){
				params.addValue("situacao", "LOTADO");
			}
			
			StringBuilder sql = new StringBuilder("UPDATE estoques SET descricao = :descricao, tamanho = :tamanho, situacao = :situacao WHERE id = :id");
			*/
			
			StringBuilder sql = new StringBuilder("UPDATE estoques SET situacao = :situacao ");
			
			if (vo.getDescricao() != "" && vo.getTamanho() != 0){
				sql.append(", descricao = :descricao, tamanho = :tamanho ");
			}
			
			sql.append(" WHERE id = :id");
			
			jdbcTemplate.update(sql.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<EstoqueVO> listar(int obj, int idProduto) throws SQLException{
		
		try{
			//MapSqlParameterSource params = new MapSqlParameterSource();
			//params.addValue("id", idProduto);
			
			StringBuilder sql = new StringBuilder(" SELECT id, descricao, tamanho, totalunidades, situacao  FROM estoques ");
			
			if (obj != 0){
				sql.append(" WHERE totalunidades < tamanho ");
			}
			
			if (idProduto != 0){
				sql.append(" OR id = (SELECT id_estoque FROM produtos WHERE id = " + idProduto + ") ");
			}
			
			sql.append(" ORDER BY id ");
			
			List<EstoqueVO> lista = new ArrayList<EstoqueVO>();
			List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql.toString(), new MapSqlParameterSource());
			
			for (Map resultado: resultSet){
				
				EstoqueVO vo = new EstoqueVO();
				
				vo.setIdEstoque((int) resultado.get("id"));
				vo.setDescricao((String) resultado.get("descricao"));
				vo.setTamanho((int) resultado.get("tamanho"));
				vo.setTotalunidades((int) resultado.get("totalunidades"));
				vo.setSituacao((String) resultado.get("situacao"));
				
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
	public void excluir(EstoqueVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", vo.getIdEstoque());
			
			StringBuilder sql = new StringBuilder("DELETE FROM estoques WHERE id = :id");
			
			jdbcTemplate.update(sql.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Integer verificarEspaco(int idEstoque, int idProduto) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("idEstoque", idEstoque);
			params.addValue("idProduto", idProduto);
			
			StringBuilder sqlPrincipal = new StringBuilder("SELECT (tamanho-totalunidades)espaco FROM estoques WHERE id = :idEstoque");
			StringBuilder sqlTotalUnidades = new StringBuilder();
			StringBuilder sqlSecundario = new StringBuilder();
			
			Integer totalUnidades;
			Integer result;

			sqlTotalUnidades.append("SELECT SUM(unidades) FROM produtos WHERE id != :idProduto");

			totalUnidades = jdbcTemplate.queryForObject(sqlTotalUnidades.toString(), params, Integer.class);
			
			if (totalUnidades == null){
				totalUnidades = 0;
			}
			
			sqlSecundario.append("SELECT (tamanho- "+ totalUnidades +")espaco FROM estoques WHERE id = :idEstoque ");
			
			if (idProduto == 0){
				result = jdbcTemplate.queryForObject(sqlPrincipal.toString(), params, Integer.class);
			}
			else{
				totalUnidades = jdbcTemplate.queryForObject(sqlTotalUnidades.toString(), params, Integer.class);
				result = jdbcTemplate.queryForObject(sqlSecundario.toString(), params, Integer.class);
			}
			
			return result;
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Integer verificarProdutoEstoque(EstoqueVO vo) throws SQLException{
		
		try{
		
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", vo.getIdEstoque());
			
			StringBuilder sql = new StringBuilder("SELECT COUNT(e.id) FROM estoques e INNER JOIN produtos p ");
			sql.append(" ON (p.id_estoque = e.id) WHERE e.id = :id ");
			
			return jdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
}

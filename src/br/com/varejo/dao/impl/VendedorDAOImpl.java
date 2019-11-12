package br.com.varejo.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.varejo.dao.VendedorDAO;
import br.com.varejo.vo.VendedorVO;

@Repository
public class VendedorDAOImpl implements VendedorDAO {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * {@inheritDoc}
	 */
	public boolean validarDados(VendedorVO vo) throws SQLException{
	
		try{
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("login", vo.getLogin());
			params.addValue("senha", vo.getSenha());
			
			StringBuilder sql = new StringBuilder("SELECT id, nome, cpf, email FROM vendedores WHERE login = :login AND senha = :senha");
			
			List<Map<String,Object>> resultSet = jdbcTemplate.queryForList(sql.toString(), params);
			Iterator iterator = resultSet.iterator();
			
			if (iterator.hasNext()){
				
				for (Map resultado: resultSet){
					vo.setIdVendedor((int) resultado.get("id"));
					vo.setNome((String) resultado.get("nome"));
					vo.setCpf((String) resultado.get("cpf"));
					vo.setEmail((String) resultado.get("email"));
				}
				
				return true;
				
			}
		
		}
		catch(Exception e){
			throw new SQLException(e);
		}
	
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Integer contar(Integer id, String valor, String campo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", id);
			params.addValue("valor", valor);
			
			StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM vendedores WHERE ");
			
			if (id != null){
				sql.append(" id != :id AND ");
			}
			
			sql.append(campo);
			sql.append(" = :valor");
			
			return jdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void incluir(VendedorVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("login", vo.getLogin());
			params.addValue("senha", vo.getSenha());
			params.addValue("nome", vo.getNome());
			params.addValue("cpf", vo.getCpf().replaceAll("[.-]", ""));
			params.addValue("email", vo.getEmail());
			
			StringBuilder sql = new StringBuilder("INSERT INTO vendedores (nome,login,senha,cpf,email) VALUES (:nome, :login, :senha, :cpf, :email)");
			
			jdbcTemplate.update(sql.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int atualizar(VendedorVO vo) throws SQLException{
		
		try{
			 
			MapSqlParameterSource params = new MapSqlParameterSource();
			StringBuilder sql = new StringBuilder();
			
			params.addValue("id", vo.getIdVendedor());
			
			int result;
			
			if (vo.getSenha() == null){
				
				params.addValue("nome", vo.getNome());
				params.addValue("cpf", vo.getCpf().replaceAll("[.-]", ""));
				params.addValue("email", vo.getEmail());
				
				sql.append("UPDATE vendedores SET nome = :nome, cpf = :cpf, email = :email WHERE id = :id");
				
				result = 0;
		
			}else{
				
				params.addValue("senha", vo.getSenha());
				
				sql.append("UPDATE vendedores SET senha = :senha WHERE id = :id");
				
				result = 1;
				
			}
			
			jdbcTemplate.update(sql.toString(), params);
			
			return result;
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}

}

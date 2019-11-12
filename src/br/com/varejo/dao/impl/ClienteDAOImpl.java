package br.com.varejo.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.varejo.dao.ClienteDAO;
import br.com.varejo.vo.ClienteVO;

@Repository
public class ClienteDAOImpl implements ClienteDAO {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * {@inheritDoc}
	 */
	public void incluir(ClienteVO vo) throws SQLException{
			
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("nome", vo.getNome());
			params.addValue("cpf", vo.getCpf().replaceAll("[.-]", ""));
			params.addValue("email", vo.getEmail());
			
			StringBuilder sql = new StringBuilder("INSERT INTO clientes (nome, cpf, email) VALUES (:nome, :cpf, :email)");
			
			jdbcTemplate.update(sql.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void atualizar(ClienteVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", vo.getIdCliente());
			params.addValue("nome", vo.getNome());
			params.addValue("cpf", vo.getCpf().replaceAll("[.-]", ""));
			params.addValue("email", vo.getEmail());
			
			StringBuilder sql = new StringBuilder("UPDATE clientes SET nome = :nome, cpf = :cpf, email = :email WHERE id = :id");
			
			jdbcTemplate.update(sql.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Integer contar(Integer id, String valor, String campo) throws SQLException{
		
		try{
		
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", id);
			params.addValue("valor", valor);
			
			StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM clientes WHERE ");
			
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
	public List<ClienteVO> listar() throws SQLException{
		
		try{
		
			StringBuilder sql = new StringBuilder(" SELECT id, nome, cpf, email FROM clientes ORDER BY id ");
			
			List<ClienteVO> lista = new ArrayList<ClienteVO>();
			List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql.toString(), new MapSqlParameterSource());
			
			for (Map resultado: resultSet){
				
				ClienteVO vo = new ClienteVO();
				
				vo.setIdCliente((int) resultado.get("id"));
				vo.setNome((String) resultado.get("nome"));
				
				String cpf = (String) resultado.get("cpf"); 
				
				StringBuilder cpfFormatado = new StringBuilder();
				cpfFormatado.append(cpf.substring(0,3));
				cpfFormatado.append(".");
				cpfFormatado.append(cpf.substring(3, 6));
				cpfFormatado.append(".");
				cpfFormatado.append(cpf.substring(6, 9));
				cpfFormatado.append("-");
				cpfFormatado.append(cpf.substring(9, 11));
				
				vo.setCpf(cpfFormatado.toString());
				vo.setEmail((String)resultado.get("email"));
				
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
	public void excluir(ClienteVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", vo.getIdCliente());
			
			StringBuilder sql = new StringBuilder("DELETE FROM clientes WHERE id = :id");
			
			jdbcTemplate.update(sql.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Integer verificarClienteVenda(ClienteVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", vo.getIdCliente());
			
			StringBuilder sql = new StringBuilder("SELECT COUNT(c.id) FROM clientes c INNER JOIN vendas v ");
			sql.append(" ON (v.id_cliente = c.id) WHERE c.id = :id ");
			
			return jdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
}

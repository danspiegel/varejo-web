package br.com.varejo.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.varejo.dao.VendaDAO;
import br.com.varejo.vo.ProdutoVendaVO;
import br.com.varejo.vo.VendaVO;

@Repository
public class VendaDAOImpl implements VendaDAO{

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * {@inheritDoc}
	 */
	public List<VendaVO> listar(int vendedor) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id_vendedor", vendedor);
			
			StringBuilder sql = new StringBuilder(" SELECT id, valor, id_cliente, datahora, valorpago, troco, id_produto, quantidade, valorproduto FROM vendas ");
			sql.append(" INNER JOIN produto_vendas ON (id = id_venda) WHERE id_vendedor = :id_vendedor ");
			
			List<VendaVO> lista = new ArrayList<VendaVO>();
			List<Map<String,Object>> resultSet = jdbcTemplate.queryForList(sql.toString(), params);
			
			for(Map resultado: resultSet){
				
				VendaVO vo = new VendaVO();
				SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				ProdutoVendaVO produtoVenda = new ProdutoVendaVO();
				
				vo.setIdVenda((int) resultado.get("id"));
				vo.setValor(BigDecimal.valueOf((Double) resultado.get("valor")));
				vo.setIdCliente((int) resultado.get("id_cliente"));
				
				String dataHora = dataFormatada.format(resultado.get("datahora"));
				
				vo.setDatahora(dataHora);
				vo.setValorpago(BigDecimal.valueOf((Double) resultado.get("valorpago")));
				vo.setTroco(BigDecimal.valueOf((Double) resultado.get("troco")));
				
				produtoVenda.setIdProduto((int) resultado.get("id_produto"));
				produtoVenda.setQuantidade((int) resultado.get("quantidade"));
				produtoVenda.setValorproduto(BigDecimal.valueOf((Double) resultado.get("valorproduto")));
				
				vo.setProdutovenda(produtoVenda);
				
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
	public void incluir(VendaVO vo) throws SQLException{
		
		try{
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id_vendedor", vo.getIdVendedor());
			params.addValue("id_cliente", vo.getIdCliente());
			params.addValue("valor", vo.getValor());
			params.addValue("valorpago", vo.getValorpago());
			params.addValue("troco", vo.getTroco());
			params.addValue("id_produto", vo.getProdutovenda().getIdProduto());
			params.addValue("quantidade", vo.getProdutovenda().getQuantidade());
			params.addValue("valorproduto", vo.getProdutovenda().getValorproduto());
			
			StringBuilder sqlVenda = new StringBuilder("INSERT INTO vendas (valor, id_cliente, id_vendedor, valorpago, troco) ");
			sqlVenda.append("VALUES (:valor, :id_cliente, :id_vendedor, :valorpago, :troco)");
			
			StringBuilder sqlProdutoVenda = new StringBuilder("INSERT INTO produto_vendas (id_produto, id_venda, quantidade, valorproduto) ");
			sqlProdutoVenda.append("VALUES (:id_produto, (SELECT MAX(id) FROM vendas), :quantidade, :valorproduto)");
			
			StringBuilder sqlAtualizarProduto = new StringBuilder("UPDATE produtos SET unidades = unidades - :quantidade WHERE id = :id_produto");
			
			StringBuilder sqlAtualizarEstoque = new StringBuilder("UPDATE estoques SET totalunidades = totalunidades - :quantidade ");
			sqlAtualizarEstoque.append("WHERE id = (SELECT id_estoque FROM produtos WHERE id = :id_produto)");
			
			jdbcTemplate.update(sqlVenda.toString(), params);
			
			jdbcTemplate.update(sqlProdutoVenda.toString(), params);
				
			jdbcTemplate.update(sqlAtualizarProduto.toString(), params);
					
			jdbcTemplate.update(sqlAtualizarEstoque.toString(), params);
			
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
}

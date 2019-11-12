package br.com.varejo.vo;

import java.math.BigDecimal;

public class ProdutoVendaVO {
	private int idProduto;
	private int idVenda;
	private int quantidade;
	private BigDecimal valorproduto;
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public BigDecimal getValorproduto() {
		return valorproduto;
	}
	public void setValorproduto(BigDecimal valorproduto) {
		this.valorproduto = valorproduto;
	}

}

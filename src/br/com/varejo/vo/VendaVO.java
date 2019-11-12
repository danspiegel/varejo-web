package br.com.varejo.vo;

import java.math.BigDecimal;
import java.util.Date;

public class VendaVO {
	private int idVenda;
	private BigDecimal valor;
	private int idCliente;
	private int idVendedor;
	private BigDecimal valorpago;
	private BigDecimal troco;
	private String datahora;
	private ProdutoVendaVO produtovenda;
	
	public ProdutoVendaVO getProdutovenda() {
		return produtovenda;
	}
	public void setProdutovenda(ProdutoVendaVO produtovenda) {
		this.produtovenda = produtovenda;
	}
	public int getIdVenda(){
		return idVenda;
	}
	public void setIdVenda(int idVenda){
		this.idVenda = idVenda;
	}
	public int getIdCliente(){
		return idCliente;
	}
	public void setIdCliente(int idCliente){
		this.idCliente = idCliente;
	}
	public int getIdVendedor(){
		return idVendedor;
	}
	public void setIdVendedor(int idVendedor){
		this.idVendedor = idVendedor;
	}
	public String getDatahora(){
		return datahora;
	}
	public void setDatahora(String datahora){
		this.datahora = datahora;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getValorpago() {
		return valorpago;
	}
	public void setValorpago(BigDecimal valorpago) {
		this.valorpago = valorpago;
	}
	public BigDecimal getTroco() {
		return troco;
	}
	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}
	
}

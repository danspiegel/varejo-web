package br.com.varejo.vo;

public class RetornoAjaxVO {

	private String tipoRetornado;
	private Object objetoRetornado;
	private int tipoException;
	private String exceptionRetornada;
	private String pagina;
	private VendedorVO vendedor;
	
	public String getTipoRetornado() {
		return tipoRetornado;
	}
	public void setTipoRetornado(String tipoRetornado) {
		this.tipoRetornado = tipoRetornado;
	}
	public Object getObjetoRetornado() {
		return objetoRetornado;
	}
	public void setObjetoRetornado(Object objetoRetornado) {
		this.objetoRetornado = objetoRetornado;
	}
	public int getTipoException() {
		return tipoException;
	}
	public void setTipoException(int tipoException) {
		this.tipoException = tipoException;
	}
	public String getExceptionRetornada() {
		return exceptionRetornada;
	}
	public void setExceptionRetornada(String exceptionRetornada) {
		this.exceptionRetornada = exceptionRetornada;
	}
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	public VendedorVO getVendedor() {
		return vendedor;
	}
	public void setVendedor(VendedorVO vendedor) {
		this.vendedor = vendedor;
	}
	
}

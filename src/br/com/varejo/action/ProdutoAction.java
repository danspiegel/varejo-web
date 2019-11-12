package br.com.varejo.action;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.facade.ProdutoFacade;
import br.com.varejo.vo.ProdutoVO;
import br.com.varejo.vo.RetornoAjaxVO;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class ProdutoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7940906826896643351L;
	private static final String RETORNO_AJAX = "retornoAjax";
	private ProdutoVO vo;
	private int obj;
	private RetornoAjaxVO retornoAjax;
	private List<ProdutoVO> lista;
	
	@Autowired
	private ProdutoFacade facade;
	
	public String incluir(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.incluir(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.produto.cadastrar.sucesso"));
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.produto.cadastrar.erro")+e.getMessage());
		}
		catch(BusinessException e){
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.produto.cadastrar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String atualizar(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.atualizar(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.produto.atualizar.sucesso"));
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.produto.atualizar.erro")+e.getMessage());
		}
		catch(BusinessException e){
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.produto.atualizar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String excluir(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.excluir(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.produto.excluir.sucesso"));
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.produto.excluir.erro")+e.getMessage());
		}
		catch(BusinessException e){
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.produto.excluir.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String listar(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			lista = facade.listar(obj);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(lista);
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.produto.listar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}

	public ProdutoVO getVo() {
		return vo;
	}

	public void setVo(ProdutoVO vo) {
		this.vo = vo;
	}

	public List<ProdutoVO> getLista() {
		return lista;
	}

	public void setLista(List<ProdutoVO> lista) {
		this.lista = lista;
	}

	public ProdutoFacade getFacade() {
		return facade;
	}

	public void setFacade(ProdutoFacade facade) {
		this.facade = facade;
	}

	public RetornoAjaxVO getRetornoAjax() {
		return retornoAjax;
	}

	public void setRetornoAjax(RetornoAjaxVO retornoAjax) {
		this.retornoAjax = retornoAjax;
	}

	public int getObj() {
		return obj;
	}

	public void setObj(int obj) {
		this.obj = obj;
	}

}

package br.com.varejo.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.varejo.facade.VendaFacade;
import br.com.varejo.vo.RetornoAjaxVO;
import br.com.varejo.vo.VendaVO;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class VendaAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7816570456603423516L;
	private static final String RETORNO_AJAX = "retornoAjax";
	private VendaVO vo;
	private List<VendaVO> lista;
	private RetornoAjaxVO retornoAjax;
	
	HttpSession session;
	
	@Autowired
	private VendaFacade facade;
	
	public String incluir(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.incluir(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.venda.cadastrar.sucesso"));
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.venda.cadastrar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String listar(){
		
		retornoAjax = new RetornoAjaxVO();
		session = ServletActionContext.getRequest().getSession();
		
		try{
			
			lista = facade.listar((int) session.getAttribute("idVendedor"));
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(lista);
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.venda.listar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}

	public VendaVO getVo() {
		return vo;
	}

	public void setVo(VendaVO vo) {
		this.vo = vo;
	}

	public List<VendaVO> getLista() {
		return lista;
	}

	public void setLista(List<VendaVO> lista) {
		this.lista = lista;
	}

	public VendaFacade getFacade() {
		return facade;
	}

	public void setFacade(VendaFacade facade) {
		this.facade = facade;
	}

	public RetornoAjaxVO getRetornoAjax() {
		return retornoAjax;
	}

	public void setRetornoAjax(RetornoAjaxVO retornoAjax) {
		this.retornoAjax = retornoAjax;
	}
	
}

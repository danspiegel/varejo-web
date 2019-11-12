package br.com.varejo.action;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.facade.ClienteFacade;
import br.com.varejo.vo.ClienteVO;
import br.com.varejo.vo.RetornoAjaxVO;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class ClienteAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 435731188540147889L;
	private static final String RETORNO_AJAX = "retornoAjax";
	private ClienteVO vo;
	private RetornoAjaxVO retornoAjax;
	private List<ClienteVO> lista;
	
	@Autowired
	private ClienteFacade facade;

	public String incluir(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.incluir(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.cliente.cadastrar.sucesso"));
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.cliente.cadastrar.erro")+e.getMessage());
		}
		catch(BusinessException e){
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.cliente.cadastrar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String atualizar(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.atualizar(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.cliente.atualizar.sucesso"));
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.cliente.atualizar.erro")+e.getMessage());
		}
		catch(BusinessException e){
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.cliente.atualizar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String listar(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			lista = facade.listar();
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(lista);
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.cliente.listar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String excluir(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.excluir(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.cliente.excluir.sucesso"));
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.cliente.excluir.erro")+e.getMessage());
		}
		catch(BusinessException e){
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.cliente.excluir.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}

	public ClienteVO getVo() {
		return vo;
	}

	public void setVo(ClienteVO vo) {
		this.vo = vo;
	}

	public List<ClienteVO> getLista() {
		return lista;
	}

	public void setLista(List<ClienteVO> lista) {
		this.lista = lista;
	}

	public ClienteFacade getFacade() {
		return facade;
	}

	public void setFacade(ClienteFacade facade) {
		this.facade = facade;
	}

	public RetornoAjaxVO getRetornoAjax() {
		return retornoAjax;
	}

	public void setRetornoAjax(RetornoAjaxVO retornoAjax) {
		this.retornoAjax = retornoAjax;
	}
	
}

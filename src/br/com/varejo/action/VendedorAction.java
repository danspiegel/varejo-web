package br.com.varejo.action;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.facade.VendedorFacade;
import br.com.varejo.vo.RetornoAjaxVO;
import br.com.varejo.vo.VendedorVO;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class VendedorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7907251285459064598L;
	private static final String RETORNO_AJAX = "retornoAjax";
	private VendedorVO vo;
	private RetornoAjaxVO retornoAjax;
	
	HttpSession session;
	
	@Autowired
	private VendedorFacade facade;
	
	public String validarDados(){
		
		retornoAjax = new RetornoAjaxVO();
		session = ServletActionContext.getRequest().getSession();
		
		try{
			
			if (facade.validarDados(vo)){
				
				retornoAjax.setTipoRetornado(SUCCESS);
				retornoAjax.setObjetoRetornado(vo);
				retornoAjax.setPagina("../pages/index.jsp");
				
				session.setAttribute("idVendedor", vo.getIdVendedor());
				session.setAttribute("login", vo.getLogin());
				session.setAttribute("senha", vo.getSenha());
				session.setAttribute("nome", vo.getNome());
				session.setAttribute("cpf", vo.getCpf());
				session.setAttribute("email", vo.getEmail());
				
			}else{
				
				retornoAjax.setTipoRetornado(ERROR);
				retornoAjax.setObjetoRetornado(getText("msg.vendedor.login.invalido"));
				
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.vendedor.login.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String exibir(){
		
		retornoAjax = new RetornoAjaxVO();
		session = ServletActionContext.getRequest().getSession();
		VendedorVO vendedor = new VendedorVO();
		
		try{
			
			retornoAjax.setTipoRetornado(SUCCESS);
			
			vendedor.setIdVendedor((int) session.getAttribute("idVendedor"));
			vendedor.setLogin((String)session.getAttribute("login"));
			vendedor.setSenha((String)session.getAttribute("senha"));
			vendedor.setNome((String)session.getAttribute("nome"));
			vendedor.setCpf((String)session.getAttribute("cpf"));
			vendedor.setEmail((String)session.getAttribute("email"));
			
			retornoAjax.setVendedor(vendedor);
			
		}
		catch(Exception e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.vendedor.dados.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String incluir(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.incluir(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.vendedor.cadastrar.sucesso"));
			retornoAjax.setPagina("../pages/login.jsp");
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.vendedor.cadastrar.erro")+e.getMessage());
		}
		catch(BusinessException e){
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.vendedor.cadastrar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String atualizar(){
		
		retornoAjax = new RetornoAjaxVO();
		session = ServletActionContext.getRequest().getSession();
		
		try{
			
			if (facade.atualizar(vo) == 0){
				
				session.removeAttribute("nome");
				session.removeAttribute("cpf");
				session.removeAttribute("email");
				
				session.setAttribute("nome", vo.getNome());
				session.setAttribute("cpf", vo.getCpf());
				session.setAttribute("email", vo.getEmail());
				
			}else{
				
				session.removeAttribute("senha");
				
				session.setAttribute("senha", vo.getSenha());
				
			}
			
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.vendedor.atualizar.sucesso"));
			retornoAjax.setVendedor(vo);
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.vendedor.atualizar.erro")+e.getMessage());
		}
		catch(BusinessException e){
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.vendedor.atualizar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String logout(){
		
		retornoAjax = new RetornoAjaxVO();
		session = ServletActionContext.getRequest().getSession();
		
		try{
	
			session.invalidate();
			
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setPagina("../pages/login.jsp");
			
		}
		catch(Exception e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.vendedor.sair.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public VendedorVO getVo() {
		return vo;
	}

	public void setVo(VendedorVO vo) {
		this.vo = vo;
	}

	public VendedorFacade getFacade() {
		return facade;
	}

	public void setFacade(VendedorFacade facade) {
		this.facade = facade;
	}

	public RetornoAjaxVO getRetornoAjax() {
		return retornoAjax;
	}

	public void setRetornoAjax(RetornoAjaxVO retornoAjax) {
		this.retornoAjax = retornoAjax;
	}
	
}

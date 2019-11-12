package br.com.varejo.action;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.varejo.exception.BusinessException;
import br.com.varejo.facade.EstoqueFacade;
import br.com.varejo.vo.EstoqueVO;
import br.com.varejo.vo.RetornoAjaxVO;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class EstoqueAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3039746281581700954L;
	private static final String RETORNO_AJAX = "retornoAjax";
	private EstoqueVO vo;
	private int obj;
	private int idProduto;
	private RetornoAjaxVO retornoAjax;
	private List<EstoqueVO> lista;
	
	@Autowired
	private EstoqueFacade facade;
	
	public String incluir(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.incluir(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.estoque.cadastrar.sucesso"));
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.estoque.cadastrar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String atualizar(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.atualizar(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.estoque.atualizar.sucesso"));
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.estoque.atualizar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String listar(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			lista = facade.listar(obj, idProduto);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(lista);
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.estoque.listar.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}
	
	public String excluir(){
		
		retornoAjax = new RetornoAjaxVO();
		
		try{
			
			facade.excluir(vo);
			retornoAjax.setTipoRetornado(SUCCESS);
			retornoAjax.setObjetoRetornado(getText("msg.estoque.excluir.sucesso"));
			
		}
		catch(SQLException e){
			e.printStackTrace();
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.estoque.excluir.erro")+e.getMessage());
		}
		catch(BusinessException e){
			retornoAjax.setTipoRetornado(ERROR);
			retornoAjax.setExceptionRetornada(getText("msg.estoque.excluir.erro")+e.getMessage());
		}
		
		return RETORNO_AJAX;
	}

	public EstoqueVO getVo() {
		return vo;
	}

	public void setVo(EstoqueVO vo) {
		this.vo = vo;
	}

	public List<EstoqueVO> getLista() {
		return lista;
	}

	public void setLista(List<EstoqueVO> lista) {
		this.lista = lista;
	}

	public EstoqueFacade getFacade() {
		return facade;
	}

	public void setFacade(EstoqueFacade facade) {
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

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
}

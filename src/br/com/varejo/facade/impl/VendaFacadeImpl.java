package br.com.varejo.facade.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.varejo.dao.VendaDAO;
import br.com.varejo.facade.VendaFacade;
import br.com.varejo.vo.VendaVO;

@Service
public class VendaFacadeImpl implements VendaFacade{

	@Autowired
	private VendaDAO dao;
	
	/**
	 * {@inheritDoc}
	 */
	public void incluir(VendaVO vo) throws SQLException{
		dao.incluir(vo);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<VendaVO> listar(int vendedor) throws SQLException{
		return dao.listar(vendedor);
	}
	
}

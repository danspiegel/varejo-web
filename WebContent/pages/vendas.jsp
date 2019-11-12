<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../includes/css/bootstrap.min.css">
<link rel="stylesheet" href="../includes/js/datatables/dataTables.bootstrap.css">
<script type="text/javascript" src="../includes/js/auxiliares/jquery.min.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/bootstrap.min.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/jquery.price_format.2.0.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/jquery.price_format.2.0.min.js"></script>
<script type="text/javascript" src="../includes/js/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../includes/js/datatables/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/validar_campos.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/mensagens.js"></script>
<title>Varejo Web - Vendas</title>
</head>
<body>
<div class="container">
  <h2><b><i>VAREJO WEB</i></b></h2>
  <ul class="nav nav-tabs">
    <li><a href="<c:url value="index.jsp"/>">Vendedor</a></li>
    <li><a href="<c:url value="clientes.jsp"/>">Clientes</a></li>
    <li><a href="<c:url value="estoques.jsp"/>">Estoques</a></li>
	<li><a href="<c:url value="produtos.jsp"/>">Produtos</a></li>
	<li class="active"><a href="<c:url value="vendas.jsp"/>">Vendas</a></li>
	<button id="bt_sair" class="btn btn-info">Sair</button>
  </ul>
  
  <c:set var="id" value='<%= session.getAttribute("idVendedor") %>'/>
  
  <c:if test="${id == null}">
  	<c:redirect url="login.jsp" />
  </c:if>
  
  <div class="tab-content">
    <br/>
    
   	  <!-- ***** MENSAGEM INÍCIO ***** -->
  	  <div id="msg_retorno_venda" style="display:none;"></div>
  	  <!-- ***** MENSAGEM FIM ***** -->
  	  
  	  <input class="trigger" type="hidden" value="2"/>

	<table>
    	<tr>
      		<td><button id="incluir_venda" class="btn btn-info" data-toggle="modal" data-target="#cadastro_venda">Cadastrar</button></td>
	  	</tr>
	</table>
	<br/>
	<br/>
	<div id="div_vendas"></div>
  </div>
</div>
<div class="modal fade" id="cadastro_venda" role="dialog">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
    			<button type="button" class="close" data-dismiss="modal">&times;</button>
    			<h4 class="modal-title">Dados da Venda - Inclusão</h4>
    		</div>
    		<form id="form_incluir" class="form-horizontal">
    			<div class="modal-body">
    				<fieldset>
						<div class="form-group">
							<div class="col-md-4">
								<c:set var="idVendedor" value='<%= session.getAttribute("idVendedor") %>'/>
								<input name="vo.idVendedor" type="hidden" value="${idVendedor}"/>
								<font size="2" face="verdana">Cliente:</font>
								<select id="incl_cliente_venda" class="form-control" name="vo.idCliente" required></select>
								<font size="2" face="verdana">Produto:</font>
								<select id="incl_produto_venda" class="form-control" name="vo.produtovenda.idProduto" required></select>
								<font size="2" face="verdana">Valor Produto:</font>
								<input id="incl_produto_val_venda_action" name="vo.produtovenda.valorproduto" type="hidden" />
								<input id="incl_produto_val_venda" type="text" value="" class="form-control input-md" required readonly="true">
							</div>
							<div class="col-md-4">
								<font size="2" face="verdana">Quantidade:</font>
								<input id="incl_quantidade" name="vo.produtovenda.quantidade" type="text" class="form-control input-md"  required>
								<font size="2" face="verdana">Valor Total:</font>
								<input id="incl_valor_total_action" name="vo.valor" type="hidden" />
								<input id="incl_valor_total" type="text" class="form-control input-md" pattern="[0-9]+$" required readonly="true">
								<font size="2" face="verdana">Valor Pago:</font>
								<input id="incl_valor_pago_action" name="vo.valorpago" type="hidden" />
								<input id="incl_valor_pago" type="text" class="form-control input-md" required>
							</div>
							<div class="col-md-4">
								<font size="2" face="verdana">Troco:</font>
								<input id="incl_troco_action" name="vo.troco" type="hidden" />
								<input id="incl_troco" type="text" class="form-control input-md" required readonly="true">
							</div>
						</div>
					</fieldset>
    			</div>
    			<div class="modal-footer">
    				<button id="bt_incluir_venda" type="submit" class="btn btn-default">GRAVAR</button>
    			</div>
    		</form>
		</div>
	</div>
</div>

<script type="text/javascript" src="../includes/js/clientes/clientes_manter.js"></script>
<script type="text/javascript" src="../includes/js/clientes/clientes_ready.js"></script>
<script type="text/javascript" src="../includes/js/produtos/produtos_auxiliar.js"></script>
<script type="text/javascript" src="../includes/js/produtos/produtos_manter.js"></script>
<script type="text/javascript" src="../includes/js/produtos/produtos_ready.js"></script>
<script type="text/javascript" src="../includes/js/vendedor/vendedor_manter.js"></script>
<script type="text/javascript" src="../includes/js/vendedor/vendedor_ready.js"></script>
<script type="text/javascript" src="../includes/js/vendas/vendas_auxiliar.js"></script>
<script type="text/javascript" src="../includes/js/vendas/vendas_dados.js"></script>
<script type="text/javascript" src="../includes/js/vendas/vendas_manter.js"></script>
<script type="text/javascript" src="../includes/js/vendas/vendas_ready.js"></script>
</body>
</html>
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
<script type="text/javascript" src="../includes/js/auxiliares/jquery.maskedinput.js"></script>
<script type="text/javascript" src="../includes/js/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../includes/js/datatables/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/validar_campos.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/mensagens.js"></script>
<title>Varejo Web - Clientes</title>
</head>
<body>
<div class="container">
  <h2><b><i>VAREJO WEB</i></b></h2>
  <ul class="nav nav-tabs">
    <li><a href="<c:url value="index.jsp"/>">Vendedor</a></li>
    <li class="active"><a href="<c:url value="clientes.jsp"/>">Clientes</a></li>
    <li><a href="<c:url value="estoques.jsp"/>">Estoques</a></li>
	<li><a href="<c:url value="produtos.jsp"/>">Produtos</a></li>
	<li><a href="<c:url value="vendas.jsp"/>">Vendas</a></li>
	<button id="bt_sair" class="btn btn-info">Sair</button>
  </ul>
  
  <c:set var="id" value='<%= session.getAttribute("idVendedor") %>'/>
  
  <c:if test="${id == null}">
  	<c:redirect url="login.jsp" />
  </c:if>
  
  <div class="tab-content">
  	  <br/>
  	 
  	  <!-- ***** MENSAGEM INÍCIO ***** -->
  	  <div id="msg_retorno_cliente" style="display:none;"></div>
  	  <!-- ***** MENSAGEM FIM ***** -->
  	  
  	  <input class="trigger" type="hidden" value="2"/>
  	  
      <table>
      	<tr>
      		<td><button id="incluir_cliente" class="btn btn-info" data-toggle="modal" data-target="#cadastro_cliente">Cadastrar</button></td>
	  	</tr>
	  </table>
	  <br/>
	  <br/>
	  <div id="div_clientes"></div>
  </div>
</div>
<div class="modal fade" id="cadastro_cliente" role="dialog">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
    			<button type="button" class="close" data-dismiss="modal">&times;</button>
    			<h4 class="modal-title">Dados do Cliente - Inclusão</h4>
    		</div>
    		<form id="frm_incl_cliente" class="form-horizontal">
    			<div class="modal-body">
    				<fieldset>
						<div class="form-group">
							<div class="col-md-4">
								<input id="incl_nome" name="vo.nome" type="text" placeholder="Digite o Nome" class="form-control input-md" required="">
								<br/>
								<input id="incl_cpf" name="vo.cpf" type="text" placeholder="Digite o CPF" class="form-control input-md cliente_cpf" required="">
							</div>
							<div class="col-md-4">
								<input id="incl_email" name="vo.email" type="text" placeholder="Digite o Email" class="form-control input-md" required="">
							</div>
						</div>
					</fieldset>
    			</div>
    			<div class="modal-footer">
    				<button id="bt_incluir_cliente" class="btn btn-default" type="submit">GRAVAR</button>
    			</div>
    		</form>
		</div>
	</div>
</div>
<div class="modal fade" id="edicao_cliente" role="dialog">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
    			<button type="button" class="close" data-dismiss="modal">&times;</button>
    			<h4 class="modal-title">Dados do Cliente - Alteração</h4>
    		</div>
    		<form id="frm_atul_cliente" class="form-horizontal">
    			<div class="modal-body">
    				<fieldset>
						<div class="form-group">
							<div class="col-md-4">
								<font size="2" face="verdana">Código:</font>
								<input id="edit_id" name="vo.idCliente" type="text" class="form-control input-md" pattern="[0-9]+$" required="" readonly="true">
								<br/>
								<font size="2" face="verdana">Nome:</font>
								<input id="edit_nome" name="vo.nome" type="text" class="form-control input-md" required="">
							</div>
							<div class="col-md-4">
								<font size="2" face="verdana">CPF:</font>
								<input id="edit_cpf" name="vo.cpf" type="text" class="form-control input-md cliente_cpf" required="">
								<br/>
								<font size="2" face="verdana">Email:</font>
								<input id="edit_email" name="vo.email" type="text" class="form-control input-md" required="">
							</div>
						</div>
					</fieldset>
    			</div>
    			<div class="modal-footer">
    				<button id="bt_alterar_cliente" type="submit" class="btn btn-default">GRAVAR</button>
    			</div>
    		</form>
		</div>
	</div>
</div>
<div class="modal fade" id="exclusao_cliente" role="dialog">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
    			<br/>
    		</div>
    		<form id="frm_excl_cliente" class="form-horizontal">
    			<div class="modal-body">
    				<fieldset>
    					<input id="excl_id" name="vo.idCliente" type="hidden">
    					<font size="4" face="verdana">Deseja realmente excluir este cliente?</font>
					</fieldset>
    			</div>
    			<div class="modal-footer">
    				<button id="bt_excl_cliente" type="button" class="btn btn-default">Sim</button>
					<button id="bt_nao" type="button" class="btn btn-default" data-dismiss="modal">Não</button>
    			</div>
    		</form>
		</div>
	</div>
</div>

<script type="text/javascript" src="../includes/js/clientes/clientes_auxiliar.js"></script>
<script type="text/javascript" src="../includes/js/clientes/clientes_manter.js"></script>
<script type="text/javascript" src="../includes/js/clientes/clientes_dados.js"></script>
<script type="text/javascript" src="../includes/js/clientes/clientes_ready.js"></script>
<script type="text/javascript" src="../includes/js/vendedor/vendedor_manter.js"></script>
<script type="text/javascript" src="../includes/js/vendedor/vendedor_ready.js"></script>
</body>
</html>
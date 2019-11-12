<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Calendar" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../includes/js/auxiliares/jquery.min.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/bootstrap.min.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/jquery.maskedinput.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/validar_campos.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/mensagens.js"></script>
<link rel="stylesheet" href="../includes/css/bootstrap.min.css">
<title>Varejo Web - Vendedor</title>
</head>
<body>
<div class="container">
  <h2><b><i>VAREJO WEB</i></b></h2>
  <ul class="nav nav-tabs">
    <li class="active"><a name="menuvendedor" href="<c:url value="index.jsp"/>">Vendedor</a></li>
    <li><a href="<c:url value="clientes.jsp"/>">Clientes</a></li>
    <li><a href="<c:url value="estoques.jsp"/>">Estoques</a></li>
	<li><a href="<c:url value="produtos.jsp"/>">Produtos</a></li>
	<li><a href="<c:url value="vendas.jsp"/>">Vendas</a></li>
	<button id="bt_sair" class="btn btn-info" type="button">Sair</button>
  </ul>
  
  <c:set var="id" value='<%= session.getAttribute("idVendedor") %>'/>
  
  <c:if test="${id == null}">
  	<c:redirect url="login.jsp" />
  </c:if>
  
  <div class="tab-content">
  <br/>
	<!-- ***** MENSAGEM INÍCIO ***** -->
  	<div id="msg_retorno_index" style="display:none;"></div>
  	<!-- ***** MENSAGEM FIM ***** --> 
  	
  	<input class="trigger" type="hidden" value="1"/>
  	
  	<br/>
  	<div>
		<div class="col-md-4">
			<br/>
			<font size="3" face="verdana">Nome:</font>
			<br/>
			<input id="vend_nome" name="nome" type="text" value="" class="form-control input-md" readonly="true">
        	<br/>
        	<font size="3" face="verdana">CPF:</font>
        	<br/>
        	<input id="vend_cpf" name="cpf" type="text" value="" class="form-control input-md" readonly="true">
        	<br/>
        	<font size="3" face="verdana">Email:</font>
        	<br/>
        	<input id="vend_email" name="cpf" type="text" value="" class="form-control input-md" readonly="true">
        	<br/>
        	<button id="bt_alterar_dados" class="btn btn-info" data-toggle="modal" data-target="#dados_vendedor">Alterar Dados</button>
    	</div>
    	<div class="col-md-4">
			<br/>
    		<font size="3" face="verdana">Usuário:</font>
    		<br/>
        	<input id="vend_login" name="login" type="text" value="" class="form-control input-md" readonly="true">
	    	<br/>
	    	<font size="3" face="verdana">Senha:</font>
	    	<br/>
        	<input id="vend_senha" name="senha" type="password" value="" class="form-control input-md" readonly="true">
        	<br/>
    		<button id="bt_alterar_senha" class="btn btn-info" data-toggle="modal" data-target="#senha_vendedor">Alterar Senha</button>
    	</div>
    </div>
  </div>
</div>
<div class="modal fade" id="dados_vendedor" role="dialog">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
    			<button id="bt_dados_pessoal_close" type="button" class="close" data-dismiss="modal">&times;</button>
    			<h4 class="modal-title">Dados Pessoais - Alteração</h4>
    		</div>
    		<form id="frm_atul_dados_pessoais" class="form-horizontal">
    			<div class="modal-body">
    				<fieldset>
						<div class="form-group">
							<input class="vend_id" name="vo.idVendedor" type="hidden" value=""/>
							<div class="col-md-4">
								<input id="nome" name="vo.nome" type="text" value="" placeholder="Nome" class="form-control input-md" required>
							</div>
							<div class="col-md-4">
								<input id="cpf" name="vo.cpf" type="text" value="" placeholder="CPF" class="form-control input-md vend_cpf" required>
							</div>
							<div class="col-md-4">
								<input id="email" name="vo.email" type="text" value="" placeholder="Email" class="form-control input-md" required>
							</div>
						</div>
					</fieldset>
    			</div>
    			<div class="modal-footer">
    				<button id="bt_alterar_pessoal" type="submit" class="btn btn-default">GRAVAR</button>
    			</div>
    		</form>
		</div>
	</div>
</div>
<div class="modal fade" id="senha_vendedor" role="dialog">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
    			<button id="bt_dados_conta_close" type="button" class="close" data-dismiss="modal">&times;</button>
    			<h4 class="modal-title">Dados da Conta - Alteração</h4>
    		</div>
    		<form id="frm_atul_dados_conta" class="form-horizontal">
    			<div class="modal-body">
    				<fieldset>
						<div class="form-group">
							<input class="vend_id" name="vo.idVendedor" type="hidden" value=""/>
							<div class="col-md-4">
								<input id="id_senha" name="vo.senha" type="password" placeholder="Nova Senha" class="form-control input-md" required>
							</div>
							<div class="col-md-4">
								<input id="confirmar_senha" type="password" placeholder="Confirmar Senha" class="form-control input-md input-block-level" required>
							</div>
						</div>
					</fieldset>
    			</div>
    			<div class="modal-footer">
    				<button id="bt_alterar_conta" type="submit" class="btn btn-default">GRAVAR</button>
    			</div>
    		</form>
		</div>
	</div>
</div>

<script type="text/javascript" src="../includes/js/vendedor/vendedor_auxiliar.js"></script>
<script type="text/javascript" src="../includes/js/vendedor/vendedor_manter.js"></script>
<script type="text/javascript" src="../includes/js/vendedor/vendedor_ready.js"></script>
<script type="text/javascript" src="../includes/js/vendedor/vendedor_dados.js"></script>
</body>
</html>
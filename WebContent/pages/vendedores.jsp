<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Varejo Web - Cadastro do Vendedor</title>
<!-- CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../includes/css/bootstrap.css">
<link rel="stylesheet" href="../includes/css/style.css">
<script type="text/javascript" src="../includes/js/auxiliares/jquery.min.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/jquery.maskedinput.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/validar_campos.js"></script>
<script type="text/javascript" src="../includes/js/auxiliares/mensagens.js"></script>
</head>
<body>
	<h1 align="center"><i>VAREJO WEB</i></h1>
	<h3 align="center">Cadastro do Vendedor</h3>
	
	<input class="trigger" type="hidden" value="0"/>
	
    <div class="container" id="container-login">
        <form id="frm_incl_vendedor" class="form-signin">
        
        	<!-- ***** MENSAGEM INÍCIO ***** -->
  			<div id="msg_retorno_vendedor" style="display:none;"></div>
  			<!-- ***** MENSAGEM FIM ***** -->
  			<div class="form-group has-feedback">
				<input id="vendedor_nome" type="text" class="input-block-level" placeholder="Nome" name="vo.nome" value="" required>
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input id="vendedor_cpf" type="text" class="input-block-level" placeholder="CPF" name="vo.cpf" value="" required>
				<span class="glyphicon glyphicon-globe form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input id="vendedor_email" type="text" class="input-block-level" placeholder="Email" name="vo.email" value="" required>
            	<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
            	<input id="vendedor_login" type="text" class="input-block-level" placeholder="Usuário" name="vo.login" value="" required>
            	<span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
            	<input id="vendedor_senha" type="password" class="input-block-level" placeholder="Senha" name="vo.senha" value="" required>
            	<span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
            	<input id="vendedor_confirmar_senha" type="password" class="input-block-level" placeholder="Confirmar Senha" name="" value="" required>
            	<span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
            	<input id="bt_incluir_vendedor" class="btn btn-block btn-success" type="submit" value="Gravar"/>
            </div>
            <br/>
            <label class="login"><a href="login.jsp">Já possui login?</a></label>
        </form>
    </div>
    
<script type="text/javascript" src="../includes/js/vendedor/vendedor_auxiliar.js"></script>
<script type="text/javascript" src="../includes/js/vendedor/vendedor_manter.js"></script>
<script type="text/javascript" src="../includes/js/vendedor/vendedor_ready.js"></script>
</body>
</html>
/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	/**
	 * Funcao: $(document).ready(function()
	 * Tipo: jQuery
	 * Objetivo: Os codigos dentro desta funcao serao executados quando todos os elementos da pagina tiverem sido carregados.
	 */
	$(document).ready(function(){
		
		$('.vend_cpf').mask('999.999.999-99');
		
		$('#vendedor_cpf').mask('999.999.999-99');
		
		$('#bt_incluir_vendedor').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Preencha o Nome.',
				                         id_campo:'vendedor_nome'});
			
			$(this).validarCamposVazios({mensagem:'Preencha o CPF.',
                						 id_campo:'vendedor_cpf'});
			
			$(this).validarCamposVazios({mensagem:'Preencha o Email.',
                						 id_campo:'vendedor_email'});
			
			$(this).validarEmail({email:$('#vendedor_email').val(),
								  id_campo:'vendedor_email'});
			
			$(this).validarCamposVazios({mensagem:'Preencha o Usuario.',
                						 id_campo:'vendedor_login'});
			
			$(this).validarCamposVazios({mensagem:'Preencha a Senha.',
                						 id_campo:'vendedor_senha'});
			
			$(this).validarTamSenha('vendedor_senha');
			
			$(this).validarCamposVazios({mensagem:'Confirme a Senha.',
				 						 id_campo:'vendedor_confirmar_senha'});
			
			$(this).validarConfirmarSenha({id_senha:'vendedor_senha',
										   id_confirmar_senha:'vendedor_confirmar_senha'});
			
		});
		
		$('#bt_entrar').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Preencha o Usuario.',
                						 id_campo:'usuario'});
			
			$(this).validarCamposVazios({mensagem:'Preencha a Senha.',
				 						 id_campo:'senha'});
			
		});
		
		$('#bt_alterar_pessoal').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Preencha o Nome.',
				 						 id_campo:'nome'});

			$(this).validarCamposVazios({mensagem:'Preencha o CPF.',
				 						 id_campo:'cpf'});
			
			$(this).validarCamposVazios({mensagem:'Preencha o Email.',
				 						 id_campo:'email'});
			
			$(this).validarEmail({email:$('#email').val(),
				  				  id_campo:'email'});
			
		});
		
		$('#bt_alterar_conta').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Preencha a Senha.',
				 						 id_campo:'id_senha'});
			
			$(this).validarTamSenha('id_senha');
			
			$(this).validarCamposVazios({mensagem:'Confirme a Senha.',
				 						 id_campo:'confirmar_senha'});
			
			$(this).validarConfirmarSenha({id_senha:'id_senha',
				   						   id_confirmar_senha:'confirmar_senha'});
			
		});
	});
	
})(jQuery);
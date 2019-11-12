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
		
		$('#incl_cpf').mask('999.999.999-99');
		
		$('#edit_cpf').mask('999.999.999-99');
		
		$('#bt_incluir_cliente').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Preencha o Nome.',
				 						 id_campo:'incl_nome'});
			
			$(this).validarCamposVazios({mensagem:'Preencha o CPF.',
				 						 id_campo:'incl_cpf'});
			
			$(this).validarCamposVazios({mensagem:'Preencha o Email.',
				 						 id_campo:'incl_email'});
			
			$(this).validarEmail({email:$('#incl_email').val(),
				  				  id_campo:'incl_email'});
			
		});
		
		$('#bt_alterar_cliente').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Preencha o Nome.',
				 						 id_campo:'edit_nome'});

			$(this).validarCamposVazios({mensagem:'Preencha o CPF.',
				 						 id_campo:'edit_cpf'});

			$(this).validarCamposVazios({mensagem:'Preencha o Email.',
				 						 id_campo:'edit_email'});
			
			$(this).validarEmail({email:$('#edit_email').val(),
				  				  id_campo:'edit_email'});
			
		});
		
	});
	
})(jQuery);
/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	$(document).ready(function(){
		
		$('#bt_incluir_estoque').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Preencha a Descricao.',
				 						 id_campo:'incl_descricao'});
			
			$(this).validarCamposVazios({mensagem:'Preencha o Tamanho (unidades).',
				 						 id_campo:'incl_tamanho'});
			
			$(this).validarCamposZerados({mensagem:'O tamanho nao pode ser zero.',
										  id_campo:'incl_tamanho'});
			
		});
		
		$('#bt_alterar_estoque').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Preencha a Descricao.',
				 						 id_campo:'edit_descricao'});

			$(this).validarCamposVazios({mensagem:'Preencha o Tamanho (unidades).',
				 						 id_campo:'edit_tamanho'});
			
			$(this).validarCamposZerados({mensagem:'O tamanho nao pode ser zero.',
				  						  id_campo:'edit_tamanho'});
			
		});
		
	});
	
})(jQuery);
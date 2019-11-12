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
		
		$('#bt_alterar_dados').click(function(){
			
			$('#nome').val($('#vend_nome').val());
			$('#cpf').val($('#vend_cpf').val());
			$('#email').val($('#vend_email').val());
			
		});
		
	});
	
})(jQuery);
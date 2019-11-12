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

		/** Exibe a listagem de vendas no grid **/
		$(this).listarVenda();
		
		$('#form_incluir').submit(function(e){
			$(this).incluirVenda();
			e.preventDefault();
		});
		
	});
	
})(jQuery);
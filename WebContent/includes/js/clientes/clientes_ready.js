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
		
		/** Exibe a listagem de clientes no grid **/
		$(this).listarCliente(0);
		
		$('#frm_incl_cliente').submit(function(e){
			$(this).incluirCliente();
			e.preventDefault();
		});
		
		$('#frm_atul_cliente').submit(function(e){
			$(this).atualizarCliente();
			e.preventDefault();
		});
		
		$('#bt_excl_cliente').click(function(){
			$(this).excluirCliente();
		});
		
	});
	
})(jQuery);
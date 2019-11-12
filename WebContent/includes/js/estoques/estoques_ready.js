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
		
		/** Exibe a listagem de estoques no grid **/
		$(this).listarEstoque(0,0);
		
		$('#frm_incl_estoque').submit(function(e){
			$(this).incluirEstoque();
			e.preventDefault();
		});
		
		$('#frm_atul_estoque').submit(function(e){
			$(this).atualizarEstoque();
			e.preventDefault();
		});
		
		$('#bt_excl_estoque').click(function(){
			$(this).excluirEstoque();
		});
		
	});
	
})(jQuery);
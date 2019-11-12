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
			
		/** Exibir a lista de produtos no grid **/
		$(this).listarProduto(0);
		
		$('#frm_incl_produto').submit(function(e){
			$(this).incluirProduto();
			e.preventDefault();
		});
		
		$('#frm_atul_produto').submit(function(e){
			$('#edit_valor').click();
			$(this).atualizarProduto();
			e.preventDefault();
		});
		
		$('#bt_excl_produto').click(function(){
			$(this).excluirProduto();
		});
		
	});
	
})(jQuery);
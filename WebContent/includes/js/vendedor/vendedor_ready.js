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
		
		/** Exibe os dados do vendedor na pagina principal**/
		$(this).exibirDados($('.trigger').val());
		
		$('#frm_login_vendedor').submit(function(e){
			$(this).validarDados();
			e.preventDefault();
		});
		
		$('#frm_atul_dados_pessoais').submit(function(e){
			$(this).atualizarVendedor("#frm_atul_dados_pessoais");
			e.preventDefault();
		});
		
		$('#frm_atul_dados_conta').submit(function(e){
			$(this).atualizarVendedor("#frm_atul_dados_conta");
			e.preventDefault();
		});
		
		$('#frm_incl_vendedor').submit(function(e){
			$(this).incluirVendedor();
			e.preventDefault();
		});
		
		$('#bt_sair').click(function(){
			$(this).logoutVendedor();
		});
		
	});
	
})(jQuery);
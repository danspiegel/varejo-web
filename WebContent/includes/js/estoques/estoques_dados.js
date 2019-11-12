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
		
		/**
		 * Tipo: jQuery
		 * Objetivo: Editar o estoque, trazendo os dados correspondentes do grid para a tela de edicao
		 */
		$(document).on('click','.bt_editar_estoque',function(){
			
			$(this).each(function(){
				
				var row = $(this).closest("tr")
			    var tds = row.find("td");
				
				$.each(tds, function(index){
				    
					if(index == 0){
				    	$('#edit_id').val($(this).text());
				    }
				    else if(index == 1){
				    	$('#edit_descricao').val($(this).text());
				    }
				    else if(index == 2){
				    	$('#edit_tamanho').val($(this).text());
				    }
				    
				});
				
			});
		});
		
		/**
		 * Tipo: jQuery
		 * Objetivo: Excluir estoque, traz o id do estoque para realizar a exclusao
		 */
		$(document).on('click','.bt_excluir_estoque',function(){
			
			$(this).each(function(){
				
				var row = $(this).closest("tr")
			    var tds = row.find("td");
				
				$.each(tds, function(index){
				    
					if(index == 0){
				    	$('#excl_id').val($(this).text());
				    }
				    
				});
				
			});
		});
		
	});
	
})(jQuery);
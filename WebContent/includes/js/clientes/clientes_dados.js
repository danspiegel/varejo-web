/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	/**
	 * Funcao: $(document).ready(function()
	 * Tipo: jQuery
	 * Objetivo: Os codigos dentro desta funcao sserao executados quando todos os elementos da pagina tiverem sido carregados.
	 */
	$(document).ready(function(){
		
		/**
		 * Tipo: jQuery
		 * Objetivo: Editar cliente, trazendo os dados correspondetes do grid para a tela de edicao
		 */
		$(document).on('click','.bt_editar_cliente',function() {
			
			$(this).each(function(){
				
				var row = $(this).closest("tr")
			    var tds = row.find("td");
				
				$.each(tds, function(index){
				    
					if(index == 0){
				    	$('#edit_id').val($(this).text());
				    }
				    else if(index == 1){
				    	$('#edit_nome').val($(this).text());
				    }
				    else if(index == 2){
				    	$('#edit_cpf').val($(this).text());
				    }
				    else if(index == 3){
				    	$('#edit_email').val($(this).text());
				    }
				    
				});
				
			});
		});
		
		/**
		 * Tipo: jQuery
		 * Objetivo: Excluir cliente, traz o id do cliente para realizar a exclusao
		 */
		$(document).on('click','.bt_excluir_cliente',function() {
			
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
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
		 * Objetivo: Exibir listagem de estoques ao abrir a tela de inclusão de produto
		 */
		$(document).on('click','#incluir_produto',function(){
			
			$(this).each(function(){
				
				var row = $(this).closest("tr")
			    var tds = row.find("td");
				
				$.each(tds, function(index){

					if(index == 0){
						
						/** Exibe lista de estoques no combo de produtos **/
						$(this).listarEstoque(1,0);
						
				    }
				});
			});
			
		});
		
		/**
		 * Tipo: jQuery
		 * Objetivo: Editar o produto, trazendo os dados correspondentes do grid para a tela de edicao
		 */
		$(document).on('click','.bt_editar_produto',function(){
			
			$(this).each(function(){
				
				var row = $(this).closest("tr")
			    var tds = row.find("td");
				
				$.each(tds, function(index){
					var idProduto = 0;
					
					if(index == 0){
						idProduto = $(this).text();
						
						/** Exibe lista de estoques no combo de produtos **/
						$(this).listarEstoque(1, idProduto);
						
				    	$('#edit_id').val(idProduto);
				    	
				    }
				    else if(index == 1){
				    	$('#edit_descricao').val($(this).text());
				    }
				    else if(index == 2){
				    	var valor = $(this).text();
						var novoValor = valor.replace(',','.');
						novoValor = novoValor.trim();
				    	
				    	$('#edit_valor').val(novoValor);
				    	
				    	novoValor = novoValor.replace("R$ ","");
				    	novoValor.trim();
				    	
				    	$('#edit_valor_replace').val(novoValor);
				    	
				    	$(this).removerPriceFormat('#edit_valor','#edit_valor_replace');
				    }
				    else if(index == 3){
				    	$('#edit_unidades').val($(this).text());
				    }
				    else if(index == 4){
				    	var idEstoque = $(this).text();
				    	
				    	$('#edit_estoque option[value="' + $(this).text() + '"]').attr('selected', 'selected');
				    }
				    
				});
				
			});
			
		});
		
		/**
		 * Tipo: jQuery
		 * Objetivo: Excluir produto, traz o id do produto para realizar a exclusao
		 */
		$(document).on('click','.bt_excluir_produto',function(){
			
			$(this).each(function(){
				
				var row = $(this).closest("tr")
			    var tds = row.find("td");
				
				$.each(tds, function(index){
				    
					if(index == 0){
				    	$('#excl_id_produto').val($(this).text());
				    }
					else if (index == 4){
				    	$('#excl_id_estoque').val($(this).text());
				    }
				    
				});
				
			});
		});
		
	});
	
})(jQuery);
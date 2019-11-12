/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	/**
	 * Funcao: incluirProduto
	 * Tipo: jQuery
	 * Objetivo: Realizar a inclusao dos dados do produto
	 */
	$.fn.extend({
		
		incluirProduto: function(){
			
			$.ajax({
				type: 'post',
				cache: false,
				dataType: 'json',
				data: $('#frm_incl_produto :input').serializeArray(),
				url: 'produtoIncluir',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('.close').click();
						
						$(this).listarProduto(0);
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
		 					 					 classe_mensagem:'alert alert-success',
		 					 					 id_mensagem:'#msg_retorno_produto'});
					}
					else{
						
						$('.close').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
							 				     classe_mensagem:'alert alert-danger',
							 				     id_mensagem:'#msg_retorno_produto'});
						

					}
					
					$('#incl_descricao').val("");
					$('#incl_valor_replace').val("");
					$('#incl_valor').val("");
					$('#incl_estoque option[value="0"]').attr('selected','selected');
					$('#incl_unidades').val("");
					
				},
				
				timeout: 10000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('.close').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_produto'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: atualizarProduto
	 * Tipo: jQuery
	 * Objetivo: Realizar a atualizacao dos dados do produto
	 */
	$.fn.extend({
		
		atualizarProduto: function(){
			
			$.ajax({
				type: 'post',
				cache: false,
				dataType: 'json',
				data: $('#frm_atul_produto :input').serializeArray(),
				url: 'produtoAtualizar',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('.close').click();
						
						$(this).listarProduto(0);
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
		 					 					 classe_mensagem:'alert alert-success',
		 					 					 id_mensagem:'#msg_retorno_produto'});
					}
					else{
						
						$('.close').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
							 				     classe_mensagem:'alert alert-danger',
							 				     id_mensagem:'#msg_retorno_produto'});
						
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('.close').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_produto'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: excluirProduto
	 * Tipo: jQuery
	 * Objetivo: Realizar a exclusao dos dados do produto
	 */
	$.fn.extend({
		
		excluirProduto: function(){
			
			$.ajax({
				type: 'post',
				cache: false,
				dataType: 'json',
				data: $('#frm_excl_produto :input').serializeArray(),
				url: 'produtoExcluir',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('#bt_nao').click();
						
						$(this).listarProduto(0);
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
							 					 classe_mensagem:'alert alert-success',
							 					 id_mensagem:'#msg_retorno_produto'});
					}
					else{
						$('#bt_nao').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
							 					 classe_mensagem:'alert alert-danger',
							 					 id_mensagem:'#msg_retorno_produto'});
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('#bt_nao').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
						 					 classe_mensagem:'alert alert-danger',
						 					 id_mensagem:'#msg_retorno_produto'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: listarProduto
	 * Tipo: jQuery
	 * Objetivo: Exibir a listagem de produtos
	 */
	$.fn.extend({
		
		listarProduto: function(obj){
			
			$.ajax({
				type: 'post',
				cache: false,
				data: { "obj": obj },
				dataType: 'json',
				url: 'produtoListar',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						
						if (obj == 0){
							$(this).construir_grid_produto(retornoAjax.objetoRetornado);
						}
						else{
							$(this).construir_lista_produto(retornoAjax.objetoRetornado);
						}
					}
					else{
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
		 					 					 classe_mensagem:'alert alert-danger',
		 					 					 id_mensagem:'#msg_retorno_produto'});
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_produto'});
					
				}
				
			});
			
		}
		
	});
	
	/**
	 * Funcao: construir_grid_produto
	 * Tipo: jQuery
	 * Objetivo: Realizar a construcao do grid que vai receber os dados do produto
	 */
	$.fn.extend({
		
		construir_grid_produto: function(obj){
			
			var content = '';

			content += '<table id="tabela_produtos" class="table table-striped">';
			content += '<thead>';
			content += '<tr>';
			content += '<th>COD. PRODUTO</th>';
			content += '<th>DESCRICAO</th>';
			content += '<th>VALOR</th>';
			content += '<th>UNIDADES</th>';
			content += '<th>COD. ESTOQUE</th>';
			content += '<th width="10%"></th>';
			content += '</tr>';
	    	content += '</thead>';

	    	content += '<tbody>';
	    	
	    	if (obj.length != 0){
	    		
	    		var valor = 0;
	    		
	    		for(var i=0; obj.length > i; i++){
		    		content += '<tr>';
		    		content += '<td>'+obj[i].idProduto+'</td>';
		    		content += '<td>'+obj[i].descricao+'</td>';
					
		    		var valor = $(this).addDecimal(obj[i].valor);
		    		
					content += '<td>R$ '+ valor +'</td>';
		    		
		    		content += '<td>'+obj[i].unidades+'</td>';
		    		content += '<td>'+obj[i].idEstoque+'</td>';
		    		
		    		content += '<td><img class="bt_editar_produto" src="../img/editar.png" title="Editar" style="cursor:pointer" data-toggle="modal" data-target="#edicao_produto"/>';
		    		content += '<img class="bt_excluir_produto" src="../img/remover.png" title="Excluir" style="cursor:pointer" data-toggle="modal" data-target="#exclusao_produto"/></td>';
		    		content += '</tr>';
		    	}
	    		
	    	}
	  
	    	content += '</tbody>';
	    	content += '</table>';

	    	$('#div_produtos').html(content);
			
	    	$('#tabela_produtos').DataTable({
	    		"oLanguage": {
	    		    "sProcessing": "<b>Aguarde enquanto os dados são carregados...</b>",
	    		    "sLengthMenu": "Mostrar _MENU_ registros por pagina",
	    		    "sZeroRecords": "<font size='5' face='verdana'><p align='center'><b>NENHUM PRODUTO ENCONTRADO</b></p></font>",
	    		    "sInfoEmpty": "Exibindo 0 a 0 de 0 registros", // Mensagem que será mostrada se a tabela não tiver registros.
	    		    "sInfo": "Exibindo de _START_ a _END_ de _TOTAL_ registros", // Mostra quantos resultados estão sendo exibidos na tabela.
	    		    "sInfoFiltered": "", // Mensagem que notifica que os resultados da tabela foram filtrados.
	    		    "sSearch": "Procurar", //  Define o label do campo de busca (filtro) da tabela.
	    		    "oPaginate": {
	    		       "sFirst":    "Primeiro",
	    		       "sPrevious": "Anterior",
	    		       "sNext":     "Proximo",
	    		       "sLast":     "Ultimo"
	    		    }
	    		 }   
	    	});
	    	
		}
		
	});
	
	/**
	 * Funcao: construir_lista_produto
	 * Tipo: jQuery
	 * Objetivo: Montar a lista de produtos disponiveis para a venda
	 */
	$.fn.extend({
		
		construir_lista_produto: function(obj){
			
			var content = '';
			
			content += '<option value="0"></option>';
			content += '<option disabled>Selecione um Produto</option>'
				
			if (obj.length != 0){
				
				for(var i=0;obj.length>i;i++){
					content += '<option value="'+obj[i].idProduto+'" valorProduto="'+obj[i].valor+'">'+obj[i].descricao+'</option>';
				}
				
			}
			
			$('#incl_produto_venda').html(content);
		}
		
	});
	
})(jQuery);
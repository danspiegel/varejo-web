/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	/**
	 * Funcao: incluirEstoque
	 * Tipo: jQuery
	 * Objetivo: incluir os dados do estoque
	 */
	$.fn.extend({
		
		incluirEstoque: function(){
			
			$.ajax({
				type: 'post',
				cache: false,
				dataType: 'json',
				data: $('#frm_incl_estoque :input').serializeArray(),
				url: 'estoqueIncluir',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('.close').click();
						
						$(this).listarEstoque(0,0);
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
												 classe_mensagem:'alert alert-success',
												 id_mensagem:'#msg_retorno_estoque'});
					}
					else{
						$('.close').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
							 					 classe_mensagem:'alert alert-danger',
							 					 id_mensagem:'#msg_retorno_estoque'});
					}
					
					$('#incl_descricao').val("");
					$('#incl_tamanho').val("");
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('.close').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
											 classe_mensagem:'alert alert-danger',
											 id_mensagem:'#msg_retorno_estoque'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: atualizarEstoque
	 * Tipo: jQuery
	 * Objetivo: atualizar os dados do estoque
	 */
	$.fn.extend({
		
		atualizarEstoque: function(){
	
			$.ajax({
				type: 'post',
				cache: false,
				dataType: 'json',
				data: $('#frm_atul_estoque :input').serializeArray(),
				url: 'estoqueAtualizar',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('.close').click();
						
						$(this).listarEstoque(0,0);
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
							 					 classe_mensagem:'alert alert-success',
							 					 id_mensagem:'#msg_retorno_estoque'});
					}
					else{
						$('.close').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
							 					 classe_mensagem:'alert alert-danger',
							 					 id_mensagem:'#msg_retorno_estoque'});
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('.close').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
						 					 classe_mensagem:'alert alert-danger',
						 					 id_mensagem:'#msg_retorno_estoque'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: excluirEstoque
	 * Tipo: jQuery
	 * Objetivo: excluir os dados do estoque
	 */
	$.fn.extend({
		
		excluirEstoque: function(){
			
			$.ajax({
				type: 'post',
				cache: false,
				dataType: 'json',
				data: $('#frm_excl_estoque :input').serializeArray(),
				url: 'estoqueExcluir',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('#bt_nao').click();
						
						$(this).listarEstoque(0,0);
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
							 					 classe_mensagem:'alert alert-success',
							 					 id_mensagem:'#msg_retorno_estoque'});
					}
					else{
						$('#bt_nao').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
							 					 classe_mensagem:'alert alert-danger',
							 					 id_mensagem:'#msg_retorno_estoque'});
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('#bt_nao').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
						 					 classe_mensagem:'alert alert-danger',
						 					 id_mensagem:'#msg_retorno_estoque'});
					
				}
			});
			
		}
	
	});
	
	/**
	 * Funcao: listarEstoque
	 * Tipo: jQuery
	 * Objetivo: exibe a listagem de estoques
	 */
	$.fn.extend({
		
		listarEstoque: function(obj, idProduto){
			
			var str = '{ "obj": ' + obj + ', "idProduto": ' + idProduto + ' }';
			var json = $.parseJSON(str);
			
			$.ajax({
				type: 'post',
				cache: false,
				async: false,
				data: json,
				dataType: 'json',
				url: 'estoqueListar',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						
						if (obj == 0){
							$(this).construir_grid_estoque(retornoAjax.objetoRetornado);
						}
						else{
							$(this).construir_lista_estoque(retornoAjax.objetoRetornado);
						}
			
					}
					else{
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
							 					 classe_mensagem:'alert alert-danger',
							 					 id_mensagem:'#msg_retorno_estoque'});
							 					 
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
						 					 classe_mensagem:'alert alert-danger',
						 					 id_mensagem:'#msg_retorno_estoque'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: construir_grid_estoque
	 * Tipo: jQuery
	 * Objetivo: montar a grid que vai exibir a lista de estoques
	 */
	$.fn.extend({
		
		construir_grid_estoque: function(obj){
			
			var content = '';

			content += '<table id="tabela_estoques" class="table table-striped">';
			content += '<thead>';
			content += '<tr>';
			content += '<th>COD. ESTOQUE</th>';
			content += '<th>DESCRICAO</th>';
			content += '<th>TAMANHO</th>';
			content += '<th>TOTAL UNIDADES</th>';
			content += '<th>SITUACAO</th>';
			content += '<th width="10%"></th>'
			content += '</tr>';
	    	content += '</thead>';

	    	content += '<tbody>';
	    	
	    	if (obj.length != 0){
	    		
	    		for(var i=0; obj.length > i; i++){
		    		content += '<tr>';
		    		content += '<td>'+obj[i].idEstoque+'</td>';
		    		content += '<td>'+obj[i].descricao+'</td>';
		    		content += '<td>'+obj[i].tamanho+'</td>';
		    		content += '<td>'+obj[i].totalunidades+'</td>';
		    		
		    		if (obj[i].situacao == "LIVRE"){
		    			content += '<td><font color="green"><b>'+obj[i].situacao+'</b></font></td>';
		    		}
		    		else if (obj[i].situacao == "LOTADO"){
		    			content += '<td><font color="red"><b>'+obj[i].situacao+'</b></font></td>';
		    		}
		    		
		    		content += '<td><img class="bt_editar_estoque" src="../img/editar.png" title="Editar" style="cursor:pointer" data-toggle="modal" data-target="#edicao_estoque"/>';
		    		content += '<img class="bt_excluir_estoque" src="../img/remover.png" title="Excluir" style="cursor:pointer" data-toggle="modal" data-target="#exclusao_estoque"/></td>';
		    		content += '</tr>';
		    	}
	    		
	    	}
	  
	    	content += '</tbody>';
	    	content += '</table>';

	    	$('#div_estoques').html(content);
	    	
	    	$('#tabela_estoques').DataTable({
	    		"oLanguage": {
	    		    "sProcessing": "<b>Aguarde enquanto os dados são carregados...</b>",
	    		    "sLengthMenu": "Mostrar _MENU_ registros por pagina",
	    		    "sZeroRecords": "<font size='5' face='verdana'><p align='center'><b>NENHUM ESTOQUE ENCONTRADO</b></p></font>",
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
	 * Funcao: construir_lista_estoque
	 * Tipo: jQuery
	 * Objetivo: Montar o combo que vai exibir os estoques no cadastro de produtos
	 */
	$.fn.extend({
		
		construir_lista_estoque: function(obj){
			
			var content = '';
			
			content += '<option value="0"></option>';
			content += '<option disabled>Selecione o Estoque</option>';
			
			if (obj.length != 0){
				
				for(var i=0;obj.length>i;i++){
					content += '<option value="'+obj[i].idEstoque+'">'+obj[i].descricao+'</option>';
				}
				
			}
			
			$('#incl_estoque').html(content);
			$('#edit_estoque').html(content);
			
		}
		
	});
	
})(jQuery);
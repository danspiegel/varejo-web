/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	/**
	 * Funcao: incluirCliente
	 * Tipo: jQuery
	 * Objetivo: incluir os dados do cliente
	 */
	$.fn.extend({
		
		incluirCliente: function(){
			
			$.ajax({
				type: 'post',
				cache: false,
				dataType: 'json',
				data: $('#frm_incl_cliente :input').serializeArray(),
				url: 'clienteIncluir',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('.close').click();
						
						$(this).listarCliente(0);
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
												 classe_mensagem:'alert alert-success',
												 id_mensagem:'#msg_retorno_cliente'});
					}
					else{
						
						$('.close').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
							 					 classe_mensagem:'alert alert-danger',
							 					 id_mensagem:'#msg_retorno_cliente'});
						
					}
					
					$('#incl_nome').val("");
					$('#incl_cpf').val("");
					$('#incl_email').val("");
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('.close').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
						 					 classe_mensagem:'alert alert-danger',
						 					 id_mensagem:'#msg_retorno_cliente'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: atualizarCliente
	 * Tipo: jQuery
	 * Objetivo: atualizar os dados do cliente
	 */
	$.fn.extend({
		
		atualizarCliente: function(){
			
			$.ajax({
				type: 'post',
				cache: false,
				dataType: 'json',
				data: $('#frm_atul_cliente :input').serializeArray(),
				url: 'clienteAtualizar',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('.close').click();
						
						$(this).listarCliente(0);
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
		 					 					 classe_mensagem:'alert alert-success',
		 					 					 id_mensagem:'#msg_retorno_cliente'});
					}
					else{
						
						$('.close').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
		 					 					 classe_mensagem:'alert alert-danger',
		 					 					 id_mensagem:'#msg_retorno_cliente'});
					
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('.close').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_cliente'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: excluirCliente
	 * Tipo: jQuery
	 * Objetivo: excluir os dados do cliente
	 */
	$.fn.extend({
		
		excluirCliente: function(){
			
			$.ajax({
				type: 'post',
				cache: false,
				dataType: 'json',
				data: $('#frm_excl_cliente :input').serializeArray(),
				url: 'clienteExcluir',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('#bt_nao').click();
						
						$(this).listarCliente(0);
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
		 					 					 classe_mensagem:'alert alert-success',
		 					 					 id_mensagem:'#msg_retorno_cliente'});
					}
					else{
						$('#bt_nao').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
		 					 					 classe_mensagem:'alert alert-danger',
		 					 					 id_mensagem:'#msg_retorno_cliente'});
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('#bt_nao').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_cliente'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: listarCliente
	 * Tipo: jQuery
	 * Objetivo: exibir a listagem de clientes
	 */
	$.fn.extend({
			
		listarCliente: function(obj){
			
			$.ajax({
				type: 'get',
				cache: false,
				dataType: 'json',
				url: 'clienteListar',
				success: function(retornoAjax){
						
					if (retornoAjax.tipoRetornado == "success"){
						
						if (obj == 0){
							$(this).construir_grid_cliente(retornoAjax.objetoRetornado);
						}else{
							$(this).construir_lista_cliente(retornoAjax.objetoRetornado);
						}
						
					}
					else{
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
		 					 					 classe_mensagem:'alert alert-danger',
		 					 					 id_mensagem:'#msg_retorno_cliente'});
					}
						
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_cliente'});
						
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: construir_grid_cliente
	 * Tipo: jQuery
	 * Objetivo: montar a grid que vai exibir a lista de clientes
	 */
	$.fn.extend({
		
		construir_grid_cliente: function(obj){
			var content = '';

			content += '<table id="tabela_clientes" class="table table-striped">';
			content += '<thead>';
			content += '<tr>';
			content += '<th>COD. CLIENTE</th>';
			content += '<th>NOME</th>';
			content += '<th>CPF</th>';
			content += '<th>EMAIL</th>';
			content += '<th></th>';
			content += '</tr>';
	    	content += '</thead>';

	    	content += '<tbody>';
	    	
	    	if (obj.length != 0){
	    		
	    		for(var i=0; obj.length > i; i++){
		    		content += '<tr>';
		    		content += '<td>'+obj[i].idCliente+'</td>';
		    		content += '<td>'+obj[i].nome+'</td>';
		    		content += '<td id="cliente_cpf">'+obj[i].cpf+'</td>';
		    		content += '<td>'+obj[i].email+'</td>';
		    		
		    		/*if (obj[i].email != null){
		    			content += '<td>'+obj[i].email+'</td>';
		    		}else{
		    			content += '<td>---</td>';
		    		}*/
		    		
		    		content += '<td><img class="bt_editar_cliente" src="../img/editar.png" title="Editar" style="cursor:pointer" data-toggle="modal" data-target="#edicao_cliente"/>';
		    		content += '<img class="bt_excluir_cliente" src="../img/remover.png" title="Excluir" style="cursor:pointer" data-toggle="modal" data-target="#exclusao_cliente"/></td>';
		    		content += '</tr>';
		    	}
	    		
	    	}
	    	
	    	content += '</tbody>';
	    	content += '</table>';
	    	
	    	$('#div_clientes').html(content);
	    	
	    	$('#tabela_clientes').DataTable({
	    		"oLanguage": {
	    		    "sProcessing": "<b>Aguarde enquanto os dados são carregados...</b>",
	    		    "sLengthMenu": "Mostrar _MENU_ registros por pagina",
	    		    "sZeroRecords": "<font size='5' face='verdana'><p align='center'><b>NENHUM CLIENTE ENCONTRADO</b></p></font>",
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
	 * Funcao: construir_lista_cliente
	 * Tipo: jQuery
	 * Objetivo: Montar o combo que vai exibir os clientes para serem selecionados
	 */
	$.fn.extend({
		
		construir_lista_cliente: function(obj){
			
			var content = '';
			
			content += '<option value="0"></option>';
			content += '<option disabled>Selecione o Cliente</option>';
			
			if (obj.length != 0){
				
				for(var i=0;obj.length>i;i++){
					content += '<option value="'+obj[i].idCliente+'">'+obj[i].nome+'</option>';
				}
				
			}
			
			$('#incl_cliente_venda').html(content);
			
		}
		
	});
	
})(jQuery);
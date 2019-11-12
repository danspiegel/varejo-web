/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	/**
	 * Funcao: incluirVenda
	 * Tipo: jQuery
	 * Objetivo: realizar a inclusao de vendas
	 */
	$.fn.extend({
		
		incluirVenda: function(){
			
			$.ajax({
				type: 'post',
				cache: false,
				dataType: 'json',
				data: $('#form_incluir :input').serializeArray(),
				url: 'vendaIncluir',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('.close').click();
						
						$(this).listarVenda();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
		 					 					 classe_mensagem:'alert alert-success',
		 					 					 id_mensagem:'#msg_retorno_venda'});
					}
					else{
						$('.close').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
		 					 					 classe_mensagem:'alert alert-danger',
		 					 					 id_mensagem:'#msg_retorno_venda'});
					}
					
					$('#incl_cliente_venda option[value="0"]').attr('selected','selected');
					$('#incl_produto_venda option[value="0"]').attr('selected','selected');
					$('#incl_produto_val_venda_replace').val("");
					$('#incl_produto_val_venda').val("");
					$('#incl_quantidade').val("");
					$('#incl_valor_total_replace').val("");
					$('#incl_valor_total').val("");
					$('#incl_valor_pago_replace').val("");
					$('#incl_valor_pago').val("");
					$('#incl_troco_replace').val("");
					$('#incl_troco').val("");
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('.close').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_venda'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: listarVenda
	 * Tipo: jQuery
	 * Objetivo: exibir a listagem de vendas do vendedor
	 */
	$.fn.extend({
		
		listarVenda: function(){
			
			$.ajax({
				type: 'get',
				cache: false,
				dataType: 'json',
				url: 'vendaListar',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$(this).construir_grid_venda(retornoAjax.objetoRetornado);
					}
					else{
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
		 					 					 classe_mensagem:'alert alert-danger',
		 					 					 id_mensagem:'#msg_retorno_venda'});
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_venda'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: construir_grid_venda
	 * Tipo: jQuery
	 * Objetivo: montar o grid que vai exibir a listagem de vendas
	 */
	$.fn.extend({
		
		construir_grid_venda: function(obj){
			
			var content = '';

			content += '<table id="tabela_vendas" class="table table-striped">';
			content += '<thead>';
			content += '<tr>';
			content += '<th>COD. VENDA</th>';
			content += '<th>COD. CLIENTE</th>';
			content += '<th>VALOR TOTAL</th>';
			content += '<th>VALOR PAGO</th>';
			content += '<th>TROCO</th>';
			content += '<th>DATA/HORA</th>';
			content += '</tr>';
	    	content += '</thead>';

	    	content += '<tbody align="center">';
	    	
	    	if (obj.length != 0){
	    		
	    		for(var i=0; obj.length > i; i++){
		    		content += '<tr>';
		    		content += '<td>'+obj[i].idVenda+'</td>';
		    		content += '<td>'+obj[i].idCliente+'</td>';
		    		
		    		var valor = $(this).addDecimal(obj[i].valor);
		    		var valorPago = $(this).addDecimal(obj[i].valorpago);
		    		var troco = $(this).addDecimal(obj[i].troco);
		    		
		    		content += '<td>R$ '+ valor +'</td>';
		    		content += '<td>R$ '+ valorPago +'</td>';
		    		content += '<td>R$ '+ troco +'</td>';
		    		content += '<td>'+obj[i].datahora+'</td>';
		    		content += '</tr>';
		    	}
	    		
	    	}
	  
	    	content += '</tbody>';
	    	content += '</table>';

	    	$('#div_vendas').html(content);
			
	    	$('#tabela_vendas').DataTable({
	    		"oLanguage": {
	    		    "sProcessing": "<b>Aguarde enquanto os dados são carregados...</b>",
	    		    "sLengthMenu": "Mostrar _MENU_ registros por pagina",
	    		    "sZeroRecords": "<font size='5' face='verdana'><p align='center'><b>NENHUMA VENDA ENCONTRADA</b></p></font>",
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
	
})(jQuery);
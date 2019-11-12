/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	/**
	 * Funcao: exibirDados
	 * Tipo: jQuery
	 * Objetivo: retornar os dados do vendedor logado
	 */
	$.fn.extend({
		
		exibirDados: function(trigger){
			
			var trig = trigger.toString();
			
			if (trig == "1"){
				
				$.ajax({
					type: 'get',
					dataType: 'json',
					url: 'vendedorExibir',
					success: function(retornoAjax){
						
						if (retornoAjax.tipoRetornado == "success"){
							
							$('.vend_id').val(retornoAjax.vendedor.idVendedor);
							$('#vend_nome').val(retornoAjax.vendedor.nome);
							
							$('#vend_cpf').val(retornoAjax.vendedor.cpf);
							$('#vend_cpf').mask('999.999.999-99');
							
							
							$('#vend_email').val(retornoAjax.vendedor.email);
							$('#vend_login').val(retornoAjax.vendedor.login);
							$('#vend_senha').val(retornoAjax.vendedor.senha);
							
						}
						else{
							
							$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
			 					 					 classe_mensagem:'alert alert-danger',
			 					 					 id_mensagem:'#msg_retorno_index'});
							
						}
						
					},
					
					timeout: 5000,
					
					error: function(XMLHttpRequest, textStatus, errorThrown){
						
						$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
		 					 					 classe_mensagem:'alert alert-danger',
		 					 					 id_mensagem:'#msg_retorno_index'});
						
					}
				});
				
			}
			
		}
		
	});
	
	/**
	 * Funcao: validarDados
	 * Tipo: jQuery
	 * Objetivo: validar os dados de login do usuario
	 */
	$.fn.extend({
		
		validarDados: function(){
			
			$.ajax({
				type: 'post',
				dataType: 'json',
				data: $('#frm_login_vendedor :input').serializeArray(),
				url: 'vendedorValidar',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						window.location = retornoAjax.pagina;
					}
					else{
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
												 classe_mensagem:'alert alert-danger',
												 id_mensagem:'#msg_retorno_login'});
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
						 					 classe_mensagem:'alert alert-danger',
						 					 id_mensagem:'#msg_retorno_login'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: incluirVendedor
	 * Tipo: jQuery
	 * Objetivo: incluir os dados do vendedor
	 */
	$.fn.extend({
		
		incluirVendedor: function(){
			
			$.ajax({
				type: 'post',
				dataType: 'json',
				data: $('#frm_incl_vendedor :input').serializeArray(),
				url: 'vendedorIncluir',
				success: function(retornoAjax){
										
					if (retornoAjax.tipoRetornado == "success"){
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
												 classe_mensagem:'alert alert-success',
												 id_mensagem:'#msg_retorno_vendedor'});
						
						$('#vendedor_nome').val("");
						$('#vendedor_cpf').val("");
						$('#vendedor_email').val("");
						$('#vendedor_login').val("");
						$('#vendedor_senha').val("");
						$('#vendedor_confirmar_senha').val("");
						
						setTimeout(function () {
							window.location = retornoAjax.pagina;
			            }, 3000);
						
					}
					else{
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
		 					 					 classe_mensagem:'alert alert-danger',
		 					 					 id_mensagem:'#msg_retorno_vendedor'});
					}
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_vendedor'});
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: atualizarVendedor
	 * Tipo: jQuery
	 * Objetivo: atualizar os dados do vendedor
	 */
	$.fn.extend({
		
		atualizarVendedor: function(form){
			
			$.ajax({
				type: 'post',
				dataType: 'json',
				data: $(form+' :input').serializeArray(),
				url: 'vendedorAtualizar',
				success: function(retornoAjax){
					
					if (retornoAjax.tipoRetornado == "success"){
						$('#bt_dados_pessoal_close').click();
						$('#bt_dados_conta_close').click();
						
						$(this).exibirDados("1");
						
						$(this).exibir_mensagem({mensagem:retornoAjax.objetoRetornado,
							 					 classe_mensagem:'alert alert-success',
							 					 id_mensagem:'#msg_retorno_index'});
					}else{
						
						$('#bt_dados_pessoal_close').click();
						$('#bt_dados_conta_close').click();
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
		 					 					 classe_mensagem:'alert alert-danger',
		 					 					 id_mensagem:'#msg_retorno_index'});
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$('#bt_dados_pessoal_close').click();
					$('#bt_dados_conta_close').click();
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_index'});
					
					
				}
			});
			
		}
		
	});
	
	/**
	 * Funcao: logoutVendedor
	 * Tipo: jQuery
	 * Objetivo: Realizar logout do sistema removendo os dados da sessao
	 */
	$.fn.extend({
		
		logoutVendedor: function(){
			
			$.ajax({
				type: 'get',
				cache: false,
				dataType: 'json',
				url: 'vendedorLogout',
				success: function(retornoAjax){
				
					if (retornoAjax.tipoRetornado == "success"){
						window.location = retornoAjax.pagina;
					}
					else{
						
						$(this).exibir_mensagem({mensagem:retornoAjax.exceptionRetornada,
		 					 					 classe_mensagem:'alert alert-danger',
		 					 					 id_mensagem:'#msg_retorno_index'});
					}
					
				},
				
				timeout: 5000,
				
				error: function(XMLHttpRequest, textStatus, errorThrown){
					
					$(this).exibir_mensagem({mensagem:("Ocorreu um erro interno. " + XMLHttpRequest.responseText),
	 					 					 classe_mensagem:'alert alert-danger',
	 					 					 id_mensagem:'#msg_retorno_index'});
					
				}
			});
			
		}
		
	});
	
})(jQuery);

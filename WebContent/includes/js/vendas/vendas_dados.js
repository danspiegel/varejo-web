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
		
		$(document).on('click','#incluir_venda',function(){
			
			/** Exibe a listagem de clientes no combo da venda **/
			$(this).listarCliente(1);
			
			/** Exibir a lista de produtos no combo da venda **/
			$(this).listarProduto(1);
			
		});
		
		$('#incl_quantidade').on('blur', function(e) { 
			e.preventDefault();  

			if (($('#incl_produto_val_venda_action').val() != "") && ($('#incl_quantidade').val() != "")){
				var valorProduto = $('#incl_produto_val_venda_action').val();
				var valorTotal = valorProduto * $('#incl_quantidade').val();
				valorTotal = valorTotal.toString();
				valorTotal = valorTotal.replace(".",",");
				
				$('#incl_valor_total_action').val(valorTotal);
				
				$('#incl_valor_total').val($(this).addDecimal(valorTotal));

			}
		});
		
		$('#incl_valor_pago').on('blur', function(e) { 
			e.preventDefault();  
			
			if ($('#incl_valor_pago').val() != ""){
				var valorProduto = $('#incl_produto_val_venda_action').val();
				var valorTotal = valorProduto * $('#incl_quantidade').val();
				var valorPago = $('#incl_valor_pago_action').val();
				var troco = valorPago - valorTotal;
				troco = troco.toString();
				troco = troco.replace(".",",");
				
				$('#incl_troco').val($(this).addDecimal(troco));
			}
		});
		
		$('#incl_produto_venda').on('blur', function(e) { 
			e.preventDefault();  
			
			if ($('#incl_produto_venda').val() != ""){
				var valorProduto = $("#incl_produto_venda option:selected").attr('valorProduto');
				
				$('#incl_produto_val_venda_action').val(valorProduto);
				
				$('#incl_produto_val_venda').val($(this).addDecimal(valorProduto));
			}
			
		});
		
	});
	
})(jQuery);
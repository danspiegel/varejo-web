/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	/**
	 * Funcao: formatarMoeda
	 * Tipo: jQuery
	 * Objetivo: Formatar os campos monetarios atraves do priceFormat
	 */
	$.fn.extend({
		
		formatarMoeda: function(id){
				
			$(id).priceFormat({
				prefix: 'R$ ',
				centsSeparator: ',',
				thousandsSeparator: '.',
				centsLimit: 2
			});
			
		}
		
	});
	
	/**
	 * Funcao: $(document).ready(function()
	 * Tipo: jQuery
	 * Objetivo: Os codigos dentro desta funcao serao executados quando todos os elementos da pagina tiverem sido carregados.
	 */
	$(document).ready(function(){
		
		$(this).formatarMoeda('#incl_produto_val_venda');
		
		$(this).formatarMoeda('#incl_valor_total');
			
		$(this).formatarMoeda('#incl_valor_pago');
			
		$(this).formatarMoeda('#incl_troco');
		
		$('#bt_incluir_venda').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Selecione o Cliente.',
				 						 id_campo:'incl_cliente_venda'});
			
			$(this).validarCamposVazios({mensagem:'Selecione o Produto.',
				 						 id_campo:'incl_produto_venda'});
			
			$(this).validarCamposVazios({mensagem:'Preencha a Quantidade.',
				 						 id_campo:'incl_quantidade'});
			
			$(this).validarCamposVazios({mensagem:'Preencha o Valor Pago.',
				 						 id_campo:'incl_valor_pago'});
			
		});
		
		$('#incl_valor_total').blur(function(){
			
			var valor = $('#incl_valor_total').val();
			var valor_replace = valor.replace('R$','');
			var valor_replace = valor_replace.replace(',','.');
			var valor_replace = valor_replace.trim();
			
			$('#incl_valor_total_action').val(valor_replace);
			
		});

		$('#incl_valor_pago').blur(function(){
			
			var valor = $('#incl_valor_pago').val();
			var valor_replace = valor.replace('R$','');
			var valor_replace = valor_replace.replace(',','.');
			var valor_replace = valor_replace.trim();
			
			$('#incl_valor_pago_action').val(valor_replace);
			
		});

		$('#incl_troco').blur(function(){
	
			var valor = $('#incl_troco').val();
			var valor_replace = valor.replace('R$','');
			var valor_replace = valor_replace.replace(',','.');
			var valor_replace = valor_replace.trim();
	
			$('#incl_troco_action').val(valor_replace);
	
		});
		
	});
	
})(jQuery);
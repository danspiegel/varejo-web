/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	/**
	 * Funcao: removerPriceFormat
	 * Tipo: jQuery
	 * Objetivo: Remover a mascara do priceFormat para os dados serem enviados ao back-end
	 */
	$.fn.extend({
		
		removerPriceFormat: function(campo, novoCampo){
		
			$(campo).blur(function(){
				
				var valor = $(campo).val();
				var novoValor = valor.replace('R$','');
				novoValor = novoValor.replace(',','.');
				novoValor = novoValor.trim();
				
				$(novoCampo).val(novoValor);
				
			});
			
		}
		
	});
	
	/**
	 * Funcao: addDecimal
	 * Tipo: jQuery
	 * Objetivo: Adicionar decimal 00 para os valores inteiros.
	 */
	$.fn.extend({
		
		addDecimal: function(valor){
			
			var val = valor.toString();
			val = val.replace(".",",");
			
			var resultado = false;
			
			for (var i=0; i < val.length; i++){
    			
    			if (val[i].trim() == ","){
    				resultado = true;
    			}
    			
    		}
    		
    		if (!resultado){
    			val = val + ",00";
    		}
    		
    		return val;
			
		}
		
	});
	
	/**
	 * Funcao: $(document).ready(function()
	 * Tipo: jQuery
	 * Objetivo: Os codigos dentro desta funcao serao executados quando todos os elementos da pagina tiverem sido carregados.
	 */
	$(document).ready(function(){
		
		/**
		 * Funcao: priceFormat
		 * Tipo: jQuery
		 * Objetivo: Formatar os campos monetarios
		 */		
		$('.valorProduto').priceFormat({
			prefix: 'R$ ',
			centsSeparator: ',',
			thousandsSeparator: '.'
		});
		
		$('#bt_incluir_produto').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Preencha a Descricao.',
				 						 id_campo:'incl_descricao'});
			
			$(this).validarCamposVazios({mensagem:'Preencha o Valor.',
				 						 id_campo:'incl_valor'});
			
			$(this).validarCamposVazios({mensagem:'Selecione o Estoque.',
				 						 id_campo:'incl_estoque'});
			
			$(this).validarCamposVazios({mensagem:'Preencha as Unidades.',
				 						 id_campo:'incl_unidades'});
			
			$(this).validarCamposZerados({mensagem:'A unidade nao pode ser zero.',
										id_campo:'incl_unidades'});
			
		});
		
		$('#bt_alterar_produto').click(function(){
			
			$(this).validarCamposVazios({mensagem:'Preencha a Descricao.',
				 						 id_campo:'edit_descricao'});
			
			$(this).validarCamposVazios({mensagem:'Preencha o Valor.',
				 						 id_campo:'edit_valor'});
			
			$(this).validarCamposVazios({mensagem:'Selecione o Estoque.',
				 						 id_campo:'edit_estoque'});
			
			$(this).validarCamposVazios({mensagem:'Preencha as Unidades.',
				 						 id_campo:'edit_unidades'});
			
			$(this).validarCamposZerados({mensagem:'A unidade nao pode ser zero.',
										id_campo:'edit_unidades'});
			
		});
		
		$(this).removerPriceFormat('#incl_valor','#incl_valor_replace');
		
	});
	
})(jQuery);
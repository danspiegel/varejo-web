/**
 * Funcao: (function($){})(jQuery);
 * Objetivo: E utilizada para extender as funcoes do jQuery.
 */
(function($){
	
	/**
	 * Funcao: validarCamposVazios
	 * Tipo: jQuery
	 * Objetivo: validar se os campos estao vazios e customizar as mensagens de alerta de acordo com o campo.
	 */
	$.fn.extend({
		
		validarCamposVazios: function(options){
			
			var defaults = {
					mensagem : 'Mensagem',
					id_campo : 'id_campo'
			};
			
			var opt = $.extend(defaults, options);
			
			if ($('#'+opt.id_campo).val() == ""){
				document.getElementById(opt.id_campo).setCustomValidity(opt.mensagem);
			}
			else{
				document.getElementById(opt.id_campo).setCustomValidity('');
			}
				
		}
		
	});
	
	/**
	 * Funcao: validarTamSenha
	 * Tipo: jQuery
	 * Objetivo: validar se o tamanho da senha atende aos requisitos minimos.
	 */
	$.fn.extend({
		
		validarTamSenha: function(id_senha){
			
			if ($('#'+id_senha).val() != ""){
				
				var tam_senha = $('#'+id_senha).val().length;
				
				if (tam_senha < 6){
					document.getElementById(id_senha).setCustomValidity('A senha deve conter no minimo 6 caracteres.');
				}
				else{
					document.getElementById(id_senha).setCustomValidity('');
				}
				
			}
			
		}
		
	});
	
	/**
	 * Funcao: validarConfirmarSenha
	 * Tipo: jQuery
	 * Objetivo: validar se a confirmacao da senha corresponde com a senha digitada.
	 */
	$.fn.extend({
		
		validarConfirmarSenha: function(options){
			
			var defaults = {
					id_senha: 'id_senha',
					id_confirmar_senha : 'id_confirmar_senha'
			};
			
			var opt = $.extend(defaults, options);
			
			if ($('#'+opt.id_confirmar_senha).val() != ""){
				
				if ($('#'+opt.id_senha).val() != $('#'+opt.id_confirmar_senha).val()){
					document.getElementById(opt.id_confirmar_senha).setCustomValidity('As senhas nao correspondem.');
				}
				else{
					document.getElementById(opt.id_confirmar_senha).setCustomValidity('');
				}
				
			}
		}
		
	});
	
	/**
	 * Funcao: validarEmail
	 * Tipo: jQuery
	 * Objetivo: validar se o email esta no formato correto.
	 */
	$.fn.extend({
		
		validarEmail: function(options){
			
			var defaults = {
					email : 'Email',
					id_campo : 'id_campo'
			};
			
			var opt = $.extend(defaults, options);
			
			if (opt.email != ""){
				
				var filtro = /^[a-zA-Z0-9][a-zA-Z0-9\._-]+@([a-zA-Z0-9\._-]+\.)[a-zA-Z-0-9]{2}/;
				
				if (!filtro.test(opt.email)){
					document.getElementById(opt.id_campo).setCustomValidity('Email invalido.');
				}
				else{
					document.getElementById(opt.id_campo).setCustomValidity('');
				}
				
			}
			
		}
		
	});
	
	/**
	 * Funcao: validarCampoZerado
	 * Tipo: jQuery
	 * Objetivo: validar se os campos estao aceitando valor zero.
	 */
	$.fn.extend({
		
		validarCamposZerados: function(options){
			
			var defaults = {
				mensagem : 'Mensagem',
				id_campo : 'id_campo'
			};
			
			var opt = $.extend(defaults, options);
			
			var valor = $('#'+opt.id_campo).val();
			
			if (valor <= 0){
				document.getElementById(opt.id_campo).setCustomValidity(opt.mensagem);
			}
		}
		
	});
	
})(jQuery);
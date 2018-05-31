$.widget( "esure.popup", {
	
	
	_init : function(){
		this._createPopup();
		this._createButtons();
		if(this.options.afterInit){
			this.options.afterInit();
		}
	},
	
	_createPopup : function(){
		var $popup = $('<div></div>');
		$popup.addClass('demo-card-wide mdl-card mdl-shadow--16dp popup mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet');
		var $titleDiv = $('<div></div>');
		$titleDiv.addClass('mdl-card__title');
		var $h2Title = $('<h2></h2>');
		$h2Title.addClass('mdl-card__title-text').text(this.options.title);
		$titleDiv.append($h2Title);
		$popup.append($titleDiv);
		
		var $content = $('<div></div>');
		$content.append(this.options.content);
		$content.addClass('mdl-card__content')
		$popup.append($content);
		var $footerDiv = $('<div></div>');
		$footerDiv.addClass('mdl-card__actions mdl-card--border footer');
		$popup.append($footerDiv);
		this.$popup = $popup
		$(this.element).append($popup);
	},

	_createButtons : function(){
		if(this.options.buttons){
			var $buttonContainer = this.$popup.find('.footer');
			var $button = null;
			$.each(this.options.buttons,function(index,btn){
				$button = $('<button></button>');
				$button.addClass('mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect '+(btn.floatLeft ? '' : 'float-right'));
				if(btn.accent){
					$button.addClass('mdl-button--accent');
				}
				$button.text(btn.caption);
				if(btn.disabled){
					$button.prop('disabled','disabled');
				}
				$buttonContainer.append($button);
				$button.click(btn.onClick);
			});
		}
	},
	
	_destroy : function(){
		this.$popup.remove();
	}
});
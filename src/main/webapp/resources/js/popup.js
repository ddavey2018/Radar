$.widget( "esure.popup", {
	
	
	_init : function(){
		this._createPopup();
		this._createButtons();
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
		$(this.element).append($popup);
		var $content = $('<div></div>');
		$content.append(this.options.content);
		$content.addClass('mdl-card__content')
		$popup.append($content);
		this.$popup = $popup
	},

	_createButtons : function(){
		if(this.options.buttons){
			$.each(this.options.buttons,function(index,btn){
				console.log(btn);
			});
		}
	}
});
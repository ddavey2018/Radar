$.widget( "esure.expressionEditor", {
	
	_vars : {
		cursor_pos : 0,
		$elem : undefined,
		base_functions : [
		]
			},
	_init : function(){
		this._vars.$elem = $(this.element);
		this._prependCursor();
		this._bindEvents();
		this._setup_base_functions();
	},
	
	_setup_base_functions : function(){
		this._vars.base_functions[0] = {name : 'If',setup : this._function_if};
		this._vars.base_functions[1] = {name : 'If Two'};
	},
	
	_prependCursor : function(){
		this._vars.$elem.prepend('<div id="cursor"><input autofocus/><div class="search-results mdl-card mdl-shadow--2dp hide" >'+
				'<div class="mdl-card__content"><ul class="demo-list-item mdl-list"></ul></div>'+
				'</div></div>');
	} ,
	
	_bindEvents : function(){
		
		this._vars.$elem.on('keydown','#cursor',this,this._cursor_keydown);
	},
	
	_searchLhs : function(term){
		var matches = [];
		$.each(this._vars.base_functions,function(index,func){
			var re = new RegExp("^("+term+")","ig");
			if(func.name.match(re)){
				matches.push(func);
			}
		});
		return matches;
	},
	
	_cursor_keydown : function(evt){
		var plugin = evt.data;
		var $input = $(evt.target);
		var $searchResultsCard = $input.next('.search-results');
		if(evt.which==32){
			return false;
		}
		if($searchResultsCard.find('.selected').length > 0){
			if(evt.which==38 || evt.which==40){

				var dir = evt.which - 39;
				var $results = $('.search-results .result');
				var selectedIndex = $results.index($('.search-results .selected'));
				var newIndex = selectedIndex + dir;
				if(newIndex >=0 && newIndex<= $results.length -1){
					$('.search-results .selected').toggleClass('selected');
					$($results[newIndex]).toggleClass('selected');
				}
			
			}if(evt.which==13){
				var selectedFunction = $('.search-results .selected').data('function');
				plugin._closeSearch();
				plugin._insertItem(selectedFunction);
			}
		}else if((evt.which>=65 && evt.which<=90) || (evt.which>=48 && evt.which<=57)){
			plugin._performSearch(evt);
		}
		
	},
	
	_closeSearch : function(){
		var $searchResults = this._vars.$elem.find('.search-results');
		$searchResults.find('ul').empty();
		$searchResults.toggleClass('hide');
	},
	
	_insertItem : function(item){
		item.setup(this._vars.$elem.find('#cursor'));
	},
	
	_performSearch : function(evt){
		var plugin = evt.data;
		var $input = $(evt.target);
		var $searchResultsCard = $input.next('.search-results');
		
		
		
		var val = $input.val();
		
		var $searchResultsUl = $searchResultsCard.find('ul');
		$searchResultsUl.empty();
		var results = plugin._searchLhs(val);
		var $result;
		$.each(results,function(index,func){
			$result = $('<li class="mdl-list__item result'+(index==0?' selected':'')+'"><span class="mdl-list__item-primary-content">'+func.name+'</span></li>');
			$result.data('function',func);
			$searchResultsUl.append($result);
		});
		if($searchResultsCard.hasClass('hide')){
			$searchResultsCard.toggleClass('hide');
		}
	},
	
	_function_if : function($cursor){
		if($cursor){
			var $if = $('<div class="if"><span>If</span><div class="brackets"></div></div>');
			$cursor.replaceWith($if);
		}
	},
	
	_destroy : function(){
	}
});
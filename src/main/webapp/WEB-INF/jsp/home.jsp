<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-red.min.css">
<link rel="stylesheet" href="resources/css/home.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
	<script src="resources/js/jquery-ui.min.js"></script>
	<script src="resources/js/popup.js"></script>
<script defer src="resources/js/getmdl-select.js"></script>
<link rel="stylesheet" href="resources/css/getmdl-select.min.css">
</head>
<body>


	<!-- Always shows a header, even in smaller screens. -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
		<div class="mdl-layout__header-row">
			<!-- Title -->
			<span class="mdl-layout-title">Create a function</span>
			<!-- Add spacer, to align navigation to the right -->
			<div class="mdl-layout-spacer"></div>
			<!-- Navigation. We hide it in small screens. -->
		</div>
		</header>
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title">Title</span>
			<nav class="mdl-navigation"> <a class="mdl-navigation__link"
				href="">Link</a> <a class="mdl-navigation__link" href="">Link</a> <a
				class="mdl-navigation__link" href="">Link</a> <a
				class="mdl-navigation__link" href="">Link</a> </nav>
		</div>
		<main class="mdl-layout__content">
		<div class="page-content">
			<div id="inputs">
				Input Parameters
				<button id="add-input"
					class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
					<i class="material-icons">add</i>
				</button>
			</div>
		</div>
		<div id="hiddenContent"></div>
	</main>
	<script>
	$(document).ready(function(){
		
		$('#add-input').click(function(){
			$("<div></div>").load("resources/html/addInput.html",function(resp){
				addInputPopup(resp);
			});
		});
			
			addInputPopup = function(content){
				$('body').popup({
					title : 'Add Input Parameters',
					buttons : [
						{caption : 'Add',floatLeft : true,accent:true,disabled:true,onClick:function(evt){
							$('<span class="mdl-chip mdl-chip--deletable">'+
								    '<span class="mdl-chip__text">'+$('.popup #inputName').val()+'</span>'+
								    '<button type="button" class="mdl-chip__action"><i class="material-icons">cancel</i></button>'+
								'</span>').insertBefore($('#inputs .add-input'));
							var inputJson = {
							};
							var inputFormSerialized = $('.add-input-content form').serializeArray();
							$.each(inputFormSerialized,function(index,field){
								inputJson[field.name] = field.value;
							});
							$('#inputs .mdl-chip:last').data(inputJson);
							$('body').popup('destroy');
						}},
						{caption : 'Cancel',onClick:function(evt){
							$('body').popup('destroy');
						}}
							],
					content : content,
					afterInit : function(){
						componentHandler.upgradeElements($('.mdl-textfield,.mdl-checkbox').get());
						getmdlSelect.init('.getmdl-select');
						
					}
				});
			}
			
	
		//	getmdlSelect
		//	addInputPopup();
		$('#inputs').on('click','.mdl-chip--deletable button',function(evt){
			$(evt.target).closest('.mdl-chip--deletable').remove();
		});
	});
	
	</script>
</body>
</html>
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
<script defer src="resources/js/getmdl-select.min.js"></script>
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
				<button
					class="add-input mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
					<i class="material-icons">add</i>
				</button>
			</div>
			<div
				class="demo-card-wide mdl-card mdl-shadow--16dp popup mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet hide">
				<div class="mdl-card__title">
					<h2 class="mdl-card__title-text">Add Input Parameters</h2>
				</div>
				<div class="mdl-card__content">
					<div class="mdl-grid">
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--6-col">
							<input class="mdl-textfield__input" type="text" id="inputName">
							<label class="mdl-textfield__label" for="sample3">Input Name</label>
						</div>
						<div class="mdl-cell mdl-cell--6-col"></div>
						<!-- Simple Select with arrow -->
						<div
							class="mdl-cell mdl-cell--6-col mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select">
							<input type="text" value="" class="mdl-textfield__input"
								id="sample4" readonly> <input type="hidden" value=""
								name="sample4"> <i
								class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
							<label for="sample4" class="mdl-textfield__label">Input
								Type</label>
							<ul for="sample4"
								class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
								<li class="mdl-menu__item" data-val="DEU">Integer</li>
								<li class="mdl-menu__item" data-val="BLR">Long</li>
								<li class="mdl-menu__item" data-val="RUS">Float</li>
								<li class="mdl-menu__item" data-val="RUS">Double</li>
							</ul>
						</div>
					</div>


				</div>

				<div class="mdl-card__actions mdl-card--border">
					<button
						class="add mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
						Add</button>
					<!-- Raised button with ripple -->
					<button
						class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect float-right cancel">
						Cancel</button>
				</div>
				<div class="mdl-card__menu">
					<button
						class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
						<i class="material-icons">share</i>
					</button>
				</div>
			</div>
		</div>
	</div>
	</main>
	</div>
	<script>
		$('body').popup({
			title : 'Add Input Parameters',
			buttons : [
				{caption : 'Add'},
				{caption : 'Cancel'}
					]
		});
		$('#inputs').on('click','.mdl-chip--deletable button',function(evt){
			$(evt.target).closest('.mdl-chip--deletable').remove();
		});
		$('.popup .add').click(function(evt){
			$('<span class="mdl-chip mdl-chip--deletable">'+
				    '<span class="mdl-chip__text">'+$('.popup #inputName').val()+'</span>'+
				    '<button type="button" class="mdl-chip__action"><i class="material-icons">cancel</i></button>'+
				'</span>').insertBefore($('#inputs .add-input'));
		});
		$('#inputs button,.popup button').click(function(evt) {
			$('.popup').toggleClass('hide');
			
			$('.popup input').val('');
		});
	</script>
</body>
</html>
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
					class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
					<i class="material-icons">add</i>
				</button>
			</div>

			<div class="demo-card-wide mdl-card mdl-shadow--2dp popup">
				<div class="mdl-card__title">
					<h2 class="mdl-card__title-text">Welcome</h2>
				</div>
				<div class="mdl-card__content">
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text"
							pattern="-?[0-9]*(\.[0-9]+)?" id="sample4"> <label
							class="mdl-textfield__label" for="sample4">Input Name</label> <span
							class="mdl-textfield__error"></span>
					</div>
					<!-- Simple Select with arrow -->
    <div class="mdl-textfield mdl-js-textfield getmdl-select">
        <input type="text" value="" class="mdl-textfield__input" id="sample2" readonly>
        <input type="hidden" value="" name="sample2">
        <i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
        <label for="sample2" class="mdl-textfield__label">Input Type</label>
        <ul for="sample2" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
            <li class="mdl-menu__item" data-val="DEU">Integer</li>
            <li class="mdl-menu__item" data-val="BLR">Long</li>
            <li class="mdl-menu__item" data-val="RUS">Float</li>
            <li class="mdl-menu__item" data-val="RUS">Double</li>
        </ul>
    </div>
				</div>

				<div class="mdl-card__actions mdl-card--border">
					<button
						class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
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

			<footer class="mdl-mega-footer">
			<div class="mdl-mega-footer__middle-section">

				<div class="mdl-mega-footer__drop-down-section">
					<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
						checked>
					<h1 class="mdl-mega-footer__heading">Features</h1>
					<ul class="mdl-mega-footer__link-list">
						<li><a href="#">About</a></li>
						<li><a href="#">Terms</a></li>
						<li><a href="#">Partners</a></li>
						<li><a href="#">Updates</a></li>
					</ul>
				</div>

				<div class="mdl-mega-footer__drop-down-section">
					<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
						checked>
					<h1 class="mdl-mega-footer__heading">Details</h1>
					<ul class="mdl-mega-footer__link-list">
						<li><a href="#">Specs</a></li>
						<li><a href="#">Tools</a></li>
						<li><a href="#">Resources</a></li>
					</ul>
				</div>

				<div class="mdl-mega-footer__drop-down-section">
					<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
						checked>
					<h1 class="mdl-mega-footer__heading">Technology</h1>
					<ul class="mdl-mega-footer__link-list">
						<li><a href="#">How it works</a></li>
						<li><a href="#">Patterns</a></li>
						<li><a href="#">Usage</a></li>
						<li><a href="#">Products</a></li>
						<li><a href="#">Contracts</a></li>
					</ul>
				</div>

				<div class="mdl-mega-footer__drop-down-section">
					<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
						checked>
					<h1 class="mdl-mega-footer__heading">FAQ</h1>
					<ul class="mdl-mega-footer__link-list">
						<li><a href="#">Questions</a></li>
						<li><a href="#">Answers</a></li>
						<li><a href="#">Contact us</a></li>
					</ul>
				</div>

			</div>

			<div class="mdl-mega-footer__bottom-section">
				<div class="mdl-logo">Title</div>
				<ul class="mdl-mega-footer__link-list">
					<li><a href="#">Help</a></li>
					<li><a href="#">Privacy & Terms</a></li>
				</ul>
			</div>

			</footer>
		</div>
		</main>
	</div>
	<script>
		$('#inputs button').click(function(evt) {
			alert("sfdsf");
		});
	</script>
</body>
</html>
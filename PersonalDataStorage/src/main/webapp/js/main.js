var hasPhoto = false;
var progress = 0;

var map = {
	'name' : 0,
	'msisdn' : 0,
	'mail' : 0,
	'comment' : 0,
	'city' : 0,
	'street' : 0,
	'streetNumber' : 0,
	'flatNumber' : 0
};
$(document).ready(function() {
	$('input').bind('change', function(event) {
		doIfInMap(event.delegateTarget.name);
	});
	$('textarea').bind('change', function(event) {
		doIfInMap(event.delegateTarget.name);
	});
});

$(document).ready(function() {
	$(window).keydown(function(event) {
		if (event.keyCode == 13) {
			event.preventDefault();
			return false;
		}
	});
});

$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();
});

$(document).ready(function() {
	$('html, body').animate({
		scrollTop : $("#progress-bar").offset().top
	}, 1000);
});

function expand() {
	$('html, body').animate({
		scrollTop : $("#expander").offset().top
	}, 200);
}

function doIfInMap(name) {
	var value = map[name];
	if (value == 0) {
		setProgress();
		map[name] = 1;
	}
}

function httpGET() {
	var name = document.getElementById('name').value;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8080/PersonalDataStorage/rest/photo/".concat(name), true); // true for asynchronous 
	xmlHttp.send(null);
	hasPhoto = true;
	doIfInMap('name');
	return xmlHttp.responseText;
}

function validateForm() {
	var x = document.forms["main"]["name"].value;
	if (x == null || x == "") {
		document.getElementById('first-input').className = "form-group has-error has-feedback";
		document.getElementById('name-error').className = "control-label";
		document.getElementById('name-error-s').className = "glyphicon glyphicon-remove form-control-feedback";
		document.getElementById("name-error").scrollIntoView();
		return false;
	}
	return true;
}

function fsubmit() {
	//todo zablokowac submit enterem
	if (validateForm()) {
		if (!hasPhoto) {
			httpGET();
		}
		return true;
	}
	return false;
}

function setProgress() {
	progress = progress + 100 / 7;
	var v = progress + '%'
	document.getElementById('progress-bar').style.width = v;
}
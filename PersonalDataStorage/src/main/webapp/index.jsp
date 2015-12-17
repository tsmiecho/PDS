<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="pl_PL">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Witam</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/main.js"></script>
</head>
<body>
<fmt:setBundle basename="configuration"/>

	<div class="container">

		<div class="row">
			<img src="http://placehold.it/1200x600" class="img-thumbnail">
		</div>
		<form role="form" name="main" action="add" method="post" onsubmit="return fsubmit();" autocomplete="off">
		
			<div class="row">
				<div id="first-input" class="form-group">
					<input id="name" class="form-control input-lg" type="text" name="name" onchange="httpGET();" placeholder="<fmt:message key="name.comment"/>" />
					<span id="name-error-s" class=""></span>
					<label id="name-error" class="hidden" for="name"><fmt:message key="name.error" /></label>
				</div>
			</div>
			<div class="row">
				<div class="progress progress-striped active">
					<div id="progress-bar" class="progress-bar progress-bar-success" style="width: 0%"></div>
				</div>
			</div>
			
			<div class="row">
				<label class="control-label col-md-2" for="msisdn"><fmt:message key="msisdn.comment"/></label>
				<div class="col-md-4">
					<div class="form-group">
						<input class="form-control input-lg" type="text" name="msisdn" />
					</div>
				</div>
				<label class="control-label col-md-2" for="mail"><fmt:message key="mail.comment"/></label>
				<div class="col-md-4">
					<div class="form-group">
						<input class="form-control input-lg" type="text" name="mail" />
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group">
					<fmt:message key="comment.box.desc" />
					<textarea name="comment" class="form-control input-lg" rows="4"></textarea>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group">
					<a class="btn btn-default glyphicon" data-toggle="collapse" data-target="#expandable-row">
						<fmt:message key="adress.data.comment" />
					</a>
				</div>
			</div>
			
			<div id="expandable-row" class="row collapse">
				<div class="col-md-3">
					<div class="form-group">
						<fmt:message key="city.comment" />
						<input class="form-control input-lg" type="text" name="city" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<fmt:message key="street.comment" />
						<a href="#" data-toggle="tooltip" data-placement="left" title="<fmt:message key="if.absent.comment" />">
							<input class="form-control input-lg" type="text" name="street" />
						</a>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<fmt:message key="streetnumber.comment" />
						<input class="form-control input-lg" type="text" name="streetNumber" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<fmt:message key="flatnumber.comment" />
						<a href="#" data-toggle="tooltip" data-placement="left" title="<fmt:message key="if.absent.comment" />">
							<input class="form-control input-lg" type="text" name="flatNumber" />
						</a>
					</div>
				</div>
			</div>
			<input type="submit" />
		</form>
	</div>

</body>
</html>

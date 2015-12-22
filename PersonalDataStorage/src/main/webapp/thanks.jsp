<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="pl_PL">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Witam</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/thanks.js"></script>
</head>
<body>
<fmt:setBundle basename="configuration"/>
	<div class="container">
		<div class="row">
			<img src="images/1200x600.png" class="img-thumbnail">
		</div>
		
		<div class="row">
			<div class="separator"></div>
		</div>
		
		<div class="row">
			<div class="col-md-6">
				<label><fmt:message key="summary.comment" /></label>
			</div>
			<div class="col-md-6">
				<a id="back-href" href="/PersonalDataStorage/" ><img src="images/200x20.png" class="img-thumbnail"></a>
			</div>
		</div>
		
		<div class="row">
			<div class="separator"></div>
		</div>
	</div>

</body>
</html>

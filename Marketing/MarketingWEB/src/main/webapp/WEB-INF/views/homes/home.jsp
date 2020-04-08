<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <title>Hello, world!</title>
    <spring:url value="/resources" var="urlPublic" />
	<spring:url value="/" var="urlRoot"/>
	
	<!-- <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap/bootstrap.min.css" />'/> -->
	<link rel="stylesheet" href="${ urlPublic }/css/bootstrap/bootstrap.min.css"/>
  </head>
  <body>
    <h1>Hello, world!</h1>
    
    <button type="button" class="btn btn-primary" onclick="pruebaAjax()">Get Servicio</button>

    <script src="${ urlPublic }/js/jquery/jquery3.4.1.js"></script>
    <script src="${ urlPublic }/js/popper/popper.js"></script>
    <script src="${ urlPublic }/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript">
    function pruebaAjax() {
    	var value2 = "descripcion";
    	var data = {"ids": 1,"descripcions":value2};
    	data = JSON.stringify(data)
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${urlRoot}home/search/home",
			data : data,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				//display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				//display(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}

    </script>
  </body>
</html>
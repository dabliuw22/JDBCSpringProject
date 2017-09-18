<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tipos Producto</title>
	</head>
	<body>
		<h1>Categorias Producto</h1>
		<c:forEach items="${ list_objects }" var="tipo">
			<p>${ tipo.nombre }</p>
		</c:forEach>
		<h2>Tu Categoria es ${ object.nombre }</h2>
		<c:forEach items="${ list_product }" var="product">
			<p>${ product.nombre }</p>
		</c:forEach>
	</body>
</html>
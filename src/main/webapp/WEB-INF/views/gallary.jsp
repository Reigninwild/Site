<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reign in wild: Screenshots</title>
<link href="${pageContext.request.contextPath}/resources/style.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/layout/styles/layout.css"
	rel="stylesheet" type="text/css" media="all">
<link href="${pageContext.request.contextPath}/resources/least.min.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/least.min.js"
	defer="defer"></script>
<script src="${pageContext.request.contextPath}/resources/least.js"
	defer="defer"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<script>
$(document).ready(function(){
    $('.least-gallery').least();
});
</script>

</head>
<body>
	<%@include file="topblock.jsp"%>
	<section id="least">
	<div class="least-preview"></div>
	<ul class="least-gallery">
		<c:forEach items="${pictures}" var="picture">
			<li><a href="${picture.url}" title="${picture.description}"
				data-subtitle="View Picture" data-caption="">
					<div class="gallary_picture">
						<img src="${picture.url}" alt="${picture.description}" />
					</div>
			</a></li>
		</c:forEach>
	</ul>
	</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reign in wild: Videos</title>
<link href="${pageContext.request.contextPath}/resources/style.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/layout/styles/layout.css"
	rel="stylesheet" type="text/css" media="all">
<link href="${pageContext.request.contextPath}/resources/least.min.css"
	rel="stylesheet" />

<!-- Main Stylesheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">


<!-- bootstrap.min -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<!-- bootstrap.min -->

<!-- Main Stylesheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css">


<!-- Twitter Bootstrap -->
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- Single Page Nav -->


<script>

$(document).ready(function() {
	  $('#play-video').on('click', function(ev) {
	 
	    $("#video")[0].src += "&autoplay=1";
	    ev.preventDefault();
	 
	  });
	});

</script>


</head>
<body>


	<%@include file="topblock.jsp"%>
	<section id="least">
	<div class="least-preview"></div>

	<ul class="least-gallery">
		<c:forEach items="${videos}" var="video">
			<li><iframe id="video" width="560" height="315"
					src="${video.url}" frameborder="0" allowfullscreen></iframe></li>
		</c:forEach>
	</ul>

	</section>


</body>
</html>
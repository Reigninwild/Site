<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reign in wild: Screenshots</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/pagination/jquery.twbsPagination.js"></script>
<link href="${pageContext.request.contextPath}/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">

<link href="${pageContext.request.contextPath}/resources/least.min.css" rel="stylesheet" />
<!-- jQuery libary -->
<script src="http://code.jquery.com/jquery-latest.js" defer="defer"></script>
<!-- least.js JS-file -->
<script src="${pageContext.request.contextPath}/resources/least.min.js" defer="defer"></script>
<!-- Lazyload JS-file -->
<script src="${pageContext.request.contextPath}/resources/jquery.min.js" defer="defer"></script>

<script src="${pageContext.request.contextPath}/resources/least.js" defer="defer"></script>

<script>

$(document).ready(function(){
    $('.least-gallery').least();
});

</script>


</head>
<body>


<%@include  file="topblock.jsp" %>
      <!-- Least Gallery -->
        <section id="least">
            
            <!-- Least Gallery: Fullscreen Preview -->
            <div class="least-preview"></div>
            
            <!-- Least Gallery: Thumbnails -->
            <ul class="least-gallery">
                <!-- 1 || Element with data-caption ||-->
                <c:forEach items="${pictures}" var="picture">
                 <li>
					 <a href="${picture.url}" title="${picture.description}" data-subtitle="View Picture" data-caption=" ©Reigninwild.com, 2016">
                        <div class="gallary_picture"><img src="${picture.url}" alt="${picture.description}" /></div>
                    </a>
				 </li>
				</c:forEach>
            </ul>


        
        </section>
        <!-- Least Gallery end -->
  
  
</body>
</html>
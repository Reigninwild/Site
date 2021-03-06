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
<title>Reign in wild: News</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/pagination/jquery.twbsPagination.js"></script>
<link href="${pageContext.request.contextPath}/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">



</head>
<body>

<!-- ################################################################################################ -->
<%@include  file="topblock.jsp" %>

    <div class="wrapper row3">
  <div id="container" class="clear"> 
	<div id="news">
	<c:forEach items="${allnews}" var="news">
	<div id='news_title'>${news.newsTitle}</div>
	<div id='news_text'>${news.newsText}</div>
	<div id='news_date'><div class='glyphicon glyphicon-calendar'><fmt:formatDate value="${news.newsDate}" pattern="yyyy-MM-dd HH:mm:ss" /></div></div>
	<div class='bot_line'></div>

</c:forEach>
	</div>


    </div>
    <!-- ################################################################################################ --> 
    <!-- / container body -->
    <div class="clear"></div>
</div>


    <!-- ################################################################################################ -->
<div class="wrapper row5">
  <div id="copyright" class="clear"> 
    <p class="fl_left"> &copy; <a href="${pageContext.request.contextPath}/home">Reigninwild.com</a>, 2015</p>
  </div>
</div>
<div class="wrapper row0"><footer id="footer" class="clear"></footer></div>
<!-- ################################################################################################ --> 
   
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->

</body>
</html>
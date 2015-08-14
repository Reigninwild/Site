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
<title>News</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>



<script>


</script>

</head>
<body>

<%@include  file="topblock.jsp" %>

<div id="news">

		<jsp:useBean id="date" class="java.util.Date"/>
		<fmt:formatDate var="currentDate"  
                value="${date}"
                pattern="yyyy-MM-dd"/>
                

  					<div class="container" width="100%">
    			<div id="news_block_full">
    			
  				<div id="news_text_full">
         		${news.newsText}
         		
         		</div>
         		
         		
         		<div id="news_date">
         		<fmt:formatDate value="${news.newsDate}" pattern="dd-MM-yyyy" />
         		</div>
         		
         		<div id="news_author">
         		<div class="glyphicon glyphicon-user"></div> ${news.uuser.username}
         		</div>
         		
         		
         		
         		</div>
</div>
          
 
</div>

</body>
</html>
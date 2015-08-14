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
<title>Reign in wild</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/pagination/jquery.twbsPagination.js"></script>


<script>

		 $(document).ready(
				
		         function() {
		        	 getNews(0);
		        	 var size = '${allNews.size()}';
		        		$('#pagination-demo').twbsPagination({
		        		    totalPages: size,
		        		    visiblePages: 3,
		        		    onPageClick: function (event, page) {
		        		        $('#page-content').text('Page ' + page);
		        		    }
		        		});
		        		
		        		
		             
		         });


</script>

</head>
<body>


<%@include  file="topblock.jsp" %>

<div id="poster"><img src="${pageContext.request.contextPath}/resources/images/poster.jpg" width="100%"></img>

<c:if test="${!empty pageContext.request.userPrincipal}">
<div id="profile_name"><c:out value="${pageContext.request.userPrincipal.name}" /></div>
<div id="logout" ><a href="<c:url value="${pageContext.request.contextPath}/j_spring_security_logout" />" >logout</a></div>
</c:if>

</div>


<div id="news">
<div id="news_title">News and updates</div>
<!--  

   <jsp:useBean id="date" class="java.util.Date"/>
		<fmt:formatDate var="currentDate"  
                value="${date}"
                pattern="yyyy-MM-dd"/>
                
<c:forEach var="news" items="${allNews}" varStatus="index" >

  					<div class="container" width="100%">
    			<div id="news_block">
    			
  				<div id="news_text">
         		${news.newsText}
         		
         		</div>
         		
         		<div id="rline"><div id="read_more">Read more</div></div>
         		
         		<div id="news_date">
         		<fmt:formatDate value="${news.newsDate}" pattern="yyyy-MM-dd" />
         		</div>
         		
         		<div id="news_author">
         		<div class="glyphicon glyphicon-user"></div> ${news.uuser.username}
         		</div>
         		
         		
         		
         		</div>
</div>
          
        </c:forEach>

-->
</div>

 <button type="button" class="btn btn-danger" id="more_news" onclick="getNews(newsCount)">More news</button>

</body>
</html>
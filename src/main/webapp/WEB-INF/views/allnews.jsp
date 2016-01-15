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
<script src="${pageContext.request.contextPath}/resources/pagination/jquery.twbsPagination.js"></script>
<link href="${pageContext.request.contextPath}/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">

<script>
		 $(document).ready(
		         function() {
		        	var size = '${newsCount}';
		        	var pageCount = Math.ceil(size/3);
		        		$('#pagination-demo').twbsPagination({
		        		    totalPages: pageCount,
		        		    visiblePages: 5,
		        		    onPageClick: function (event, page) {
		        		    	getNewsCount(page);
		        		    }
		        		});
		         });
</script>

</head>
<body>

	<%@include file="topblock.jsp"%>

	<div class="wrapper row3">
		<div id="container" class="clear">
			<div id="news">
				<c:forEach items="${allnews}" var="news">
					<div id='news_title'>${news.newsTitle}</div>
					<div id='news_text'>${news.newsText}</div>
					<div id='news_date'>
						<div class='glyphicon glyphicon-calendar'>
							<fmt:formatDate value="${news.newsDate}"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</div>
					</div>
					<div class='bot_line'></div>

				</c:forEach>
				
			</div>
			<ul id="pagination-demo" class="pagination-lg"></ul>

		</div>

		<div class="clear"></div>
	</div>


	<%@include file="footer.jsp"%>


</body>
</html>
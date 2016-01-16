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
<title>Reign in wild: Home</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<link href="${pageContext.request.contextPath}/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">

</head>
<body>

	<%@include file="topblock.jsp"%>

	<div class="wrapper">
		<ul class="slides">
			<input type="radio" name="radio-btn" id="img-1" checked />
			<li class="slide-container">
				<div class="slide">
					<img
						src="${pageContext.request.contextPath}/resources/images/poster.jpg" />
				</div>
				<div class="nav">
					<label for="img-6" class="prev">&#x2039;</label> <label for="img-2"
						class="next">&#x203a;</label>
				</div>
			</li>

			<input type="radio" name="radio-btn" id="img-2" />
			<li class="slide-container">
				<div class="slide">
					<img
						src="${pageContext.request.contextPath}/resources/images/screenshots/screen1.png" />
				</div>
				<div class="nav">
					<label for="img-1" class="prev">&#x2039;</label> <label for="img-3"
						class="next">&#x203a;</label>
				</div>
			</li>

			<input type="radio" name="radio-btn" id="img-3" />
			<li class="slide-container">
				<div class="slide">
					<img
						src="${pageContext.request.contextPath}/resources/images/screenshots/screen1.png" />
				</div>
				<div class="nav">
					<label for="img-2" class="prev">&#x2039;</label> <label for="img-4"
						class="next">&#x203a;</label>
				</div>
			</li>

			<input type="radio" name="radio-btn" id="img-4" />
			<li class="slide-container">
				<div class="slide">
					<img
						src="${pageContext.request.contextPath}/resources/images/poster.jpg" />
				</div>
				<div class="nav">
					<label for="img-3" class="prev">&#x2039;</label> <label for="img-5"
						class="next">&#x203a;</label>
				</div>
			</li>

			<input type="radio" name="radio-btn" id="img-5" />
			<li class="slide-container">
				<div class="slide">
					<img
						src="${pageContext.request.contextPath}/resources/images/screenshots/screen1.png" />
				</div>
				<div class="nav">
					<label for="img-4" class="prev">&#x2039;</label> <label for="img-6"
						class="next">&#x203a;</label>
				</div>
			</li>

			<input type="radio" name="radio-btn" id="img-6" />
			<li class="slide-container">
				<div class="slide">
					<img
						src="${pageContext.request.contextPath}/resources/images/screenshots/screen1.png" />
				</div>
				<div class="nav">
					<label for="img-5" class="prev">&#x2039;</label> <label for="img-1"
						class="next">&#x203a;</label>
				</div>
			</li>

			<li class="nav-dots"><label for="img-1" class="nav-dot"
				id="img-dot-1"></label> <label for="img-2" class="nav-dot"
				id="img-dot-2"></label> <label for="img-3" class="nav-dot"
				id="img-dot-3"></label> <label for="img-4" class="nav-dot"
				id="img-dot-4"></label> <label for="img-5" class="nav-dot"
				id="img-dot-5"></label> <label for="img-6" class="nav-dot"
				id="img-dot-6"></label></li>

		</ul>

	</div>


	<div class="wrapper row3">
		<div id="container" class="clear">

			<div class="center push80">
				<h1 class="shout">Reign in wild: open world survival simulator
					for iOS and Android</h1>
				<p class="push10">Reign in wild is a survival simulation game
					with auto generated open world. You are an ordinary man who
					survived an airplane crash and found himself on a deserted tropical
					island. All you have to do is fight for life in the wild. Hunt
					animals, build shelters, fight with malevolent owners of the
					island. Using a huge amount of resources, you can craft weapons,
					buildings, traps and much more, that can help you survive.</p>
				<a href="${pageContext.request.contextPath}/about"><div
						class="learn_more2">Read more</div></a>

			</div>
		</div>

		<!-- / container body -->
		<div class="clear"></div>
	</div>

	<div class="wrapper row4">
		<footer id="footer" class="clear">

		<div class="two_third first">
			<h6 class="title">Latest news</h6>
			<div id="news">
				<p>No updates</p>
			</div>


			<div id='news_title'>
				<h>${lastNews.newsTitle}</h>
			</div>
			<div id='news_text'>
				<p>${lastNews.newsText}</p>
			</div>
			<div id='news_date'>
				<div class='glyphicon glyphicon-calendar'>
					<fmt:formatDate value="${lastNews.newsDate}"
						pattern="yyyy-MM-dd HH:mm:ss" />
				</div>
			</div>

			<div class="wrapper row228">
				<a href="${pageContext.request.contextPath}/news">
					<div class="learn_more3">More news</div>
				</a>
			</div>
		</div>




		<div class="one_third">
			<h6 class="title">Subscribe for news and updates</h6>
			<p>Leave us your email address if you would like to be on the
				mailing list for news and updates</p>
			<form action="#" method="post">
				<label for="nlt_email">Mail <span>*</span></label><label
					id="email_error">invalid emeail</label> <input class="push15"
					type="text" name="nlt_email" id="nlt_email" value="" size="22">
				<div class="learn_more2" onclick="subscribe()">Subscribe</div>
			</form>
		</div>

		</footer>

	</div>
		<%@include file="footer.jsp"%>


</body>
</html>
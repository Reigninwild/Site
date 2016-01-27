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
<title>Reign in wild: Home</title>
<head>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css">

<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>

</head>

<body id="body">
	<div id="preloader">
		<div class="loder-box">
			<div class="battery"></div>
		</div>
	</div>

	<%@include file="topblock.jsp"%>

	<main class="site-content" role="main">

	<div class="container">
		<div class="sec-title text-center white wow animated fadeInDown">
			<div class="row">
				<div class="col-xs-2"></div>
				<div class="col-xs-4">
					<div id="appstore"></div>
					Release on spring 2016
				</div>
				<div class="col-xs-4">
					<div id="google_play"></div>
					Release on spring 2016
				</div>
				<div class="col-xs-2"></div>
			</div>

		</div>

	</div>

	<section id="testimonials">

	<div class="overlay">
		<div class="container">

			<div class="sec-title text-center">
				<div class="home_header">Reign in wild: open world online
					survival simulator for iOS and Android</div>
			</div>

			<div id="home_poster">
				<img
					src="${pageContext.request.contextPath}/resources/images/poster.jpg">
			</div>

			<div id="testimonial" class=" wow animated fadeInUp">
				<div class="testimonial-item text-center">

					<p>Reign in wild is a survival simulation game with auto
						generated open world. You are an ordinary man who survived an
						airplane crash and found himself on a deserted tropical island.
						All you have to do is fight for life in the wild. Hunt animals,
						build shelters, fight with malevolent owners of the island. Using
						a huge amount of resources, you can craft weapons, buildings,
						traps and much more, that can help you survive.</p>
					<a href="${pageContext.request.contextPath}/about"
						class="btn btn-border pull-right">Read More</a>
				</div>
			</div>
		</div>
	</div>

	</section> <section id="contact">
	<div class="container">
		<div class="row">

			<div class="col-md-7 wow animated fadeInLeft">
				<div class="contact-details">
					<h3>Latest news</h3>
				</div>

				<div id='news_title'>
					<h>${lastNews.newsTitle}</h>
				</div>
				<div id='news_text'>
					<p>${lastNews.newsText}</p>

				</div>
				<div id='news_date'>
					<fmt:formatDate value="${lastNews.newsDate}" pattern="yyyy-MM-dd" />

				</div>
				<br>
				<div>
					<a href="${pageContext.request.contextPath}/news"
						class="btn btn-border2 pull-left">More news</a>
				</div>
				<br>
			</div>



			<div class="col-md-5 wow animated fadeInRight">
				<address class="contact-details">
					<h3>Contacts</h3>
					<p>
						<i class="fa fa-vk"></i><a
							href="${pageContext.request.contextPath}/index">vk.com/reigninwild</a>
					</p>
					<p>
						<i class="fa fa-facebook-square"></i><a
							href="${pageContext.request.contextPath}/index">facebook.com/reigninwild</a>
					</p>
					<p>
						<i class="fa fa-envelope"></i>reigninwild@gmail.com
					</p>
				</address>
			</div>

		</div>
	</div>
	</section> </main>

	<footer id="footer">
	<div class="container">
		<div class="row text-center">
			<div class="footer-content">
				<div class="wow animated fadeInDown">
					<p>Subscribe for news and updates</p>
					<p>Leave us your email address if you would like to be on the
						mailing list for news and updates</p>
				</div>
				<label>Mail <span>*</span></label> <label id="email_error">invalid
					email</label>
				<form action="#" method="post"
					class="subscribe-form wow animated fadeInUp">

					<div class="input-field">
						<input type="email" id="nlt_email" class="subscribe form-control"
							placeholder="Enter Your Email...">
						<button type="button" class="submit-icon" onclick="subscribe()">
							<i class="fa fa-paper-plane fa-lg"></i>
						</button>
					</div>
				</form>
				<div class="footer-social">
					<ul>
						<li class="wow animated zoomIn"><a href="#"><i
								class="fa fa-vk fa-3x"></i></a></li>
						<li class="wow animated zoomIn" data-wow-delay="0.3s"><a
							href="#"><i class="fa fa-facebook-square fa-3x"></i></a></li>
						<li class="wow animated zoomIn" data-wow-delay="0.9s"><a
							href="#"><i class="fa fa-twitter fa-3x"></i></a></li>
						<li class="wow animated zoomIn" data-wow-delay="1.2s"><a
							href="#"><i class="fa fa-youtube fa-3x"></i></a></li>
					</ul>
				</div>

				<p>
					<a href="http://reigninwild.com/">Reigninwild.com</a>. All rights
					Reserved. 2016
				</p>
			</div>
		</div>
	</div>
	</footer>

</body>
</html>

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
<title>Reign in wild: contacts</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>


</head>
<body>

<%@include  file="topblock.jsp" %>

	<div class="container">
		<div class="email_block">
			<div class="email">Email: reigninwild@gmail.com </div>
			
			
			<div class="rep_title">Report a bug</div>
			<div class="row">
				<div class="col-xs-2">
				 <div class="rep_label">Subject</div>
				</div>
				<div class="col-xs-10">
				 <input type="text" id="subject" size="30"/>
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
				 <div class="rep_label"> Bug </div>
				</div>
				<div class="col-xs-10">
				<textarea rows="10" cols="39" id="content"></textarea>
				</div>
			</div>
			
			<div class="send_button" onclick="send_report()">Send report</div>
			
		</div>
		

			<div id="parent_popup">
  				<div id="popup">
 				 Your message was successfully sent
				<a class="close"title="Close" onclick="document.getElementById('parent_popup').style.display='none';">X</a>
				</div>
			</div>
			
			<div id="parent_popup2">
  				<div id="popup">
 				 Something went wrong. Try later.
				<a class="close"title="Close" onclick="document.getElementById('parent_popup2').style.display='none';">X</a>
				</div>
			</div>
			
				<div id="parent_popup3">
  				<div id="popup">
 				 Subject too short. (4 symbols minimum)
				<a class="close"title="Close" onclick="document.getElementById('parent_popup3').style.display='none';">X</a>
				</div>
			</div>
			
			<div id="parent_popup4">
  				<div id="popup">
 				 Content too short. (10 symbols minimum)
				<a class="close"title="Close" onclick="document.getElementById('parent_popup4').style.display='none';">X</a>
				</div>
			</div>

		
	</div>
	
	
	



	
	


</body>
</html>
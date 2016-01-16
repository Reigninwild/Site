<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reign in wild: Contacts</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<link href="${pageContext.request.contextPath}/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>

	<%@include file="topblock.jsp"%>

	<div class="wrapper">

		<div class="email_block">
			<div class="email">Our contacts:</div>
			<div class="email">
				Email: <a>reigninwild@gmail.com </a>
			</div>
			<div class="email">
				VK:<a href="loh.com">address</a>
			</div>
			<div class="email">
				Facebook:<a href="loh.com">address</a>
			</div>

<!--  
			<div class="email">Tell us about found bugs and your
				suggestions for improving game world and game in general (Don't
				forget to leave your email).</div>
			<div class="row">
				<div class="col-xs-2">
					<div class="rep_label">Subject</div>
				</div>
				<div class="col-xs-9">
					<input type="text" id="subject" size="20" />
				</div>
			</div>

			<div class="row">
				<div class="col-xs-2">
					<div class="rep_label">Message</div>
				</div>
				<div class="col-xs-9">
					<textarea rows="10" cols="15" id="content"></textarea>
					<div class="send_button" onclick="send_report()">Send message</div>
				</div>

			</div>
			-->
			
			

		</div>

		<div id="parent_popup">
			<div id="popup">
				Your message was successfully sent <a class="close" title="Close"
					onclick="document.getElementById('parent_popup').style.display='none';">X</a>
			</div>
		</div>

		<div id="parent_popup2">
			<div id="popup">
				Something went wrong. Try later. <a class="close" title="Close"
					onclick="document.getElementById('parent_popup2').style.display='none';">X</a>
			</div>
		</div>

		<div id="parent_popup3">
			<div id="popup">
				Subject too short. (4 symbols minimum) <a class="close"
					title="Close"
					onclick="document.getElementById('parent_popup3').style.display='none';">X</a>
			</div>
		</div>

		<div id="parent_popup4">
			<div id="popup">
				Content too short. (10 symbols minimum) <a class="close"
					title="Close"
					onclick="document.getElementById('parent_popup4').style.display='none';">X</a>
			</div>
		</div>

	</div>


	<%@include file="footer.jsp"%>

</body>
</html>
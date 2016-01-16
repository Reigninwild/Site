<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reign in wild: authorization</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
</head>

<body>

	<p>Load pictures</p>
	<table>
		<tr>
			<td width="50%">Picture description</td>
			<td width="50%"><input id="pic_desc" name="pic_desc"
				placeholder="description" size="20" maxlength="100" type="text" />
			</td>
		</tr>
		<tr>
			<td width="50%">URL</td>
			<td width="50%"><input id="pic_url" name="url" placeholder="url"
				size="20" maxlength="200" type="text" /></td>
		</tr>

	</table>

	<input type="button" value="add picture" onclick="add_picture()">

	<div id="upload_status" class="upload_warn"></div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<p>Load videos</p>

	<div>How to add video</div>
	<p>1 Select video on youtube</p>
	<p>2 Click on the video and select "Copy embed code"</p>
	<p>
		3 From copied value pick out src value (just url) like
		"https://www.youtube.com/<b>embed</b>/vWi6lxeRz74"
	</p>


	<table>
		<tr>
			<td width="50%">Video description</td>
			<td width="50%"><input id="vid_desc" name="pic_desc"
				placeholder="description" size="20" maxlength="100" type="text" />
			</td>
		</tr>
		<tr>
			<td width="50%">URL</td>
			<td width="50%"><input id="vid_url" name="url" placeholder="url"
				size="20" maxlength="200" type="text" /></td>
		</tr>

	</table>

	<input type="button" value="add video" onclick="add_video()">

	<div id="v_upload_status" class="upload_warn"></div>


</body>
</html>
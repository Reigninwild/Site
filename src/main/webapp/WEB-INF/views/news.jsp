<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reign in wild: add news</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//tinymce.cachefly.net/4.2/tinymce.min.js"></script>

<script>tinymce.init({selector:'textarea',
	plugins: "image",      
});
</script>
</head>
<body>
	<div class="container">

		<form:form method="post" action="addnew" commandName="news"
			id="add_news">
ENG
            <table width="100%">


				<tr>
					<label>Title:</label>
					<form:input path="newsTitle" rows="1" cols="30" width="100%" />
					<form:textarea path="newsText" rows="5" cols="30" width="100%" />
				</tr>

			</table>
            RU
              <table width="100%">
				<tr>
					<form:textarea path="newsTextRU" rows="5" cols="30" width="100%" />
				</tr>

			</table>
			<input type="submit" value="Submit">
		</form:form>

	</div>

</body>
</html>



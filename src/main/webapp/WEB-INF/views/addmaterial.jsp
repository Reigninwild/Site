<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reign in wild: add materials</title>

<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
</head>
<body>


<form:form method="post" action="addmaterial" commandName="material" id="add_materials" >

         
              
                    <form:input path="materialName" width="100%" value="Material name" size="100px"/>
                    <br>
                    <form:input path="materialNameRU" width="100%" value="Material name(ru)" size="100px"/>
                    <form:input path="materialType" width="100%" value="Material type" size="100px"/>
                    <form:input path="materialDesc" width="100%" value="Material desc" size="100px"/>
                    <form:input path="materialDescRU" width="100%" value="Material desc(ru)" size="100px"/>
                    <form:input path="materialPic" width="100%" value="picture" size="100px"/>
                    <form:input path="materialStatus" width="100%" value="status" size="100px"/>
          
          
          
              <input type="submit" value="Submit">
</form:form>

</body>
</html>
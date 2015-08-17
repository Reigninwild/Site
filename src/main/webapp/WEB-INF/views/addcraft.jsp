<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reign in wild: add craft</title>

<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
</head>
<body>


<div id="select" >
<select name="Materials" class="materials_select">
   <c:forEach items="${materials}" var="material">
    <option value="${material.materialID}">${material.materialName}</option>
  </c:forEach>
</select>
</div>

         
<label>Craft Item:</label>
<select name="Materials" id="targetMaterial">
<c:forEach items="${emptyMaterials}" var="material">
    <option value="${material.materialID}">${material.materialName}</option>
  </c:forEach>
</select>
<br>
<hr>


<input type="button" value="add material" onclick="add_material()">
<br>

<div id="craft_materials">

</div>

		  <hr>
          <br>
          
              <input type="button" value="Save craft" onclick="addcraft()">


</body>
</html>
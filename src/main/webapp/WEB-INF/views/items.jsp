<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reign in wild: crafts</title>

<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>

<script>var ctx = "${pageContext.request.contextPath}"</script>

</head>
<body>

<%@include  file="topblock.jsp" %>

	<div class="container">


<div id="items">
	<div class="materials_types">
		<div class="material_types" onclick="showMaterialsType('resources')">
			<div class="row">
				<div class="col-xs-2">
					<div class="type_resources"></div>
	     		</div>
	     
	     		<div class="col-xs-8">
				<div class="type_name">Resources</div>
	    		 </div>
	    	 </div>
		</div>
		
		<div class="material_types" onclick="showMaterialsType('weapons')">
			<div class="row">
				<div class="col-xs-2">
					<div class="type_weapons"></div>
	     		</div>
	     
	     		<div class="col-xs-8">
				<div class="type_name">Weapons</div>
	    		 </div>
	    	 </div>
		</div>
		
		<div class="material_types" onclick="showMaterialsType('buildings')">
			<div class="row">
				<div class="col-xs-2">
					<div class="type_buildings"></div>
	     		</div>
	     
	     		<div class="col-xs-8">
				<div class="type_name">Buildings</div>
	    		 </div>
	    	 </div>
		</div>
		
		<div class="material_types" onclick="showMaterialsType('other')">
			<div class="row">
				<div class="col-xs-2">
					<div class="type_resources"></div>
	     		</div>
	     
	     		<div class="col-xs-8">
				<div class="type_name">Other</div>
	    		 </div>
	    	 </div>
		</div>
		


	</div>

	<div class="materials_list">
	<div class="item_back" onclick='backitems()'><div class="back">Back</div></div>

	

	</div>
</div>

</div>
</body>
</html>
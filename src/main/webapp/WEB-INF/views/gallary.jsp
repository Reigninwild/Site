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
<title>Reign in wild: Screenshots</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/pagination/jquery.twbsPagination.js"></script>
<link href="${pageContext.request.contextPath}/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">

<link href="${pageContext.request.contextPath}/resources/least.min.css" rel="stylesheet" />
<!-- jQuery libary -->
<script src="http://code.jquery.com/jquery-latest.js" defer="defer"></script>
<!-- least.js JS-file -->
<script src="${pageContext.request.contextPath}/resources/least.min.js" defer="defer"></script>
<!-- Lazyload JS-file -->
<script src="${pageContext.request.contextPath}/resources/jquery.min.js" defer="defer"></script>

<script src="${pageContext.request.contextPath}/resources/least.js" defer="defer"></script>

<script>

$(document).ready(function(){
    $('.least-gallery').least();
});

</script>


</head>
<body>


<%@include  file="topblock.jsp" %>
      <!-- Least Gallery -->
        <section id="least">
            
            <!-- Least Gallery: Fullscreen Preview -->
            <div class="least-preview"></div>
            
            <!-- Least Gallery: Thumbnails -->
            <ul class="least-gallery">
                <!-- 1 || Element with data-caption ||-->
                <li>
             
 					<iframe src="http://www.youtube.com/embed/XGSy3_Czz8k"></iframe>
                      
                </li>
                
                <!-- 2 || Element with data-caption as href-attribute ||-->
                <li>
                    <a href="${pageContext.request.contextPath}/resources/media/big/02.jpg" title="Train Rails" data-subtitle="View Picture" data-caption="Now it's possibe to add an URL-Link into caption text - <a href='http://www.google.com' target='_blank'>GOOGLE</a>">
                        <img src="${pageContext.request.contextPath}/resources/media/thumbnails/02.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                
                <!-- 3 -->
                <li>
                    <a href="${pageContext.request.contextPath}/resources/media/big/03.jpg" title="Apple" data-subtitle="View Picture">
                        <img src="${pageContext.request.contextPath}/resources/media/thumbnails/03.jpg" alt="Alt Image Text" />
                    </a>
                </li>

                <!-- 4 -->
                <li>
                    <a href="${pageContext.request.contextPath}/resources/media/big/04.jpg" title="Road Trip" data-subtitle="View Picture">
                        <img src="${pageContext.request.contextPath}/resources/media/thumbnails/04.jpg" alt="Alt Image Text" />
                    </a>
                </li>

                <!-- 5 -->
                <li>
                    <a href="${pageContext.request.contextPath}/resources/media/big/05.jpg" title="Desert" data-subtitle="View Picture">
                        <img src="${pageContext.request.contextPath}/resources/media/thumbnails/05.jpg" alt="Alt Image Text" />
                    </a>
                </li>

                <!-- 6 -->
                <li>
                    <a href="${pageContext.request.contextPath}/resources/media/big/06.jpg" title="Tree" data-subtitle="View Picture">
                        <img src="${pageContext.request.contextPath}/resources/media/thumbnails/06.jpg" alt="Alt Image Text" />
                    </a>
                </li>

                <!-- 7 -->
                <li>
                    <a href="${pageContext.request.contextPath}/resources/media/big/07.jpg" title="MacBook" data-subtitle="View Picture">
                        <img src="${pageContext.request.contextPath}/resources/media/thumbnails/07.jpg" alt="Alt Image Text" />
                    </a>
                </li>

                <!-- 8 -->
                <li>
                    <a href="${pageContext.request.contextPath}/resources/media/big/08.jpg" title="Clock" data-subtitle="View Picture">
                        <img src="${pageContext.request.contextPath}/resources/media/thumbnails/08.jpg" alt="Alt Image Text" />
                    </a>
                </li>

                <!-- 9 -->
                <li>
                    <a href="${pageContext.request.contextPath}/resources/media/big/09.jpg" title="iPhone" data-subtitle="View Picture">
                        <img src="${pageContext.request.contextPath}/resources/media/thumbnails/09.jpg" alt="Alt Image Text" />
                    </a>
                </li>

                <!-- 10 -->
                <li>
                    <a href="${pageContext.request.contextPath}/resources/media/big/10.jpg" title="New York" data-subtitle="View Picture">
                        <img src="${pageContext.request.contextPath}/resources/media/thumbnails/10.jpg" alt="Alt Image Text" />
                    </a>
                </li>
            </ul>

        </section>
        <!-- Least Gallery end -->
  
  
</body>
</html>
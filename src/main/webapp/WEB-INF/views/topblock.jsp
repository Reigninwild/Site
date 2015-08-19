<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<body>
<div id="main_top_block">
<div id="main_top_left">

<div id="more_button" onclick="show_more()"><div id="more"></div></div>
  
<div id="logo" onclick="location.href = '${pageContext.request.contextPath}/';" title="reigninwild.com"></div> 
<div class="main_top_left">

<div class="menu_item"><div class="about_i"></div>About</div>
<div class="menu_item" onclick=""><div class="news_i" onclick="toNews()"></div>News</div>
<div class="menu_item"><div class="screenshots_i"></div>Screenshots</div>
<div class="menu_item"><div class="guides_i" onclick="location.href = '${pageContext.request.contextPath}/items';"></div>Guides</div>
<div class="menu_item"><div class="contacts_i" onclick="location.href = '${pageContext.request.contextPath}/contacts';"></div>Contacts</div>

	</div>


</div>

</div>
</body>
</html>




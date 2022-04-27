<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<%@include file="include/header.jspf" %>
</head>
<body>
	<div class="bg">
		<%@include file="timezone_form.jspf" %>
		
		<%@include file="timezone_list.jspf" %>
		
		 <button onclick="window.open('https://marshmallow-qa.com/y_vacc?utm_medium=url_text&utm_source=promotion', '_blank')" class="conn">
		 	Support
		 </button>
		
		<%@include file="include/footer.jspf" %>
	</div>
</body>
</html>
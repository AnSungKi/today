<%@page import="egovframework.sayit.duplex.Duplex"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String user_id = Duplex.encrypt(request.getParameter("user_id"), "naraeIctVoteMove");
	if (user_id == null || user_id.equals("")) {
		user_id = "";
	}
	
	request.setAttribute("user_id", user_id);
%>
<html>
<head>
<title>오늘의 세종 : 새올연계</title>
<script>
function goSubmit(){
	document.getElementById('monitorForm').submit();
}
</script>
</head>
<body leftmargin="5" topmargin="0" marginwidth="0" marginheight="0">
	<form name="monitor" id="monitorForm" target="_blank" method="post" action="http://www.sejong.go.kr/monitoring/index.jsp?user_id=${user_id}">
	    <input type="hidden" id="user_id" name="user_id" value="<c:out value='${user_id }' />" />
		<a href="#" onclick="goSubmit(); return false;" target="_blank"><img src="http://www.sejong.go.kr/monitoring/saeol_banner.png" style="border:none;"></a>
	</form>
</body>
</html>
	
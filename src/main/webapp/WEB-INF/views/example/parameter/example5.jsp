<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2 style="text-align:  center; margin-top: 100px;">ids : ${ids}</h2>
	<c:forEach var="id" items="${ids}">
		<p>${id}</p>
	</c:forEach>
</body>
</html>
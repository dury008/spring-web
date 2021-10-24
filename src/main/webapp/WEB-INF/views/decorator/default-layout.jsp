<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
	<style type="text/css">
	.active { color: red !important;}
	</style>
	<sitemesh:write property = "head" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">PJH</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link" aria-current="page" href="#">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link ${menuType.name() == 'community' ? 'active' : ''}" href="/community"><spring:message code="menu.community"/></a>		   
		        </li>
		        <li class="nav-item">		          
		          <a class="nav-link ${menuType.name() == 'notice' ? 'active' : ''}" href="/notice"><spring:message code="menu.notice"/></a>		          
		        </li>
		        <li class="nav-item">	          
		          <a class="nav-link ${menuType.name() == 'faq' ? 'active' : ''}" href="/faq" ><spring:message code="menu.faq"/></a>		     
		        </li>
		        <li class="nav-item">		        
		          <a class="nav-link ${menuType.name() == 'inquiry' ? 'active' : ''}" href="/inquiry"><spring:message code="menu.inquiry"/></a>
		        </li>     
		      </ul>
		   
		    </div>
		  </div>
	</nav>
	<sitemesh:write property = "body" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix ="tag" %>


<!DOCTYPE html>

<html>

<head>

 <meta charset="UTF-8">

 <title>Example</title>

 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>

<body>

<div class = "container">
	<h2>게시물 목록</h2>
	<form action="" method="get">
		<div class="mb-3 row">
			<label for="exampleFormControlInput1" class="col-sm-2 col-form-label">종류</label>
			<div class="col-sm-10">
				<tag:bootstrap-checkbox items="${boardTypes}" values="${parameter.boardTypes}"></tag:bootstrap-checkbox>
			</div>
		</div>
		<div class="mb-3 text-center">
			<button type="submit" class="btn btn-primary">검색하기</button>
		</div>
	</form>

</div>
</body>

</html>
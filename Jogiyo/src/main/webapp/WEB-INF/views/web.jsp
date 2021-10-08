<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<h3>~조기요 주문 조기요~</h3>
		<div>
			<ul>
				<c:forEach var="item" items="${categorys}">
					<li><a href="shop/${item.categoryId}/">${item.categoryName}</a></li>
				</c:forEach>	
			</ul>
		</div>
	</div>
</body>
</html>
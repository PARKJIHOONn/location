<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>주문 등록</h1>
		<form method="post">
			<div class="row mb-3">
				<label class="form-lable col-3">주문번호:</label>
				<div class="col">
				<input type="number" name="orderid" class="form-control">
				</div>
			</div>
			<div class="row mb-3">
				<label class="form-lable col-3">고객번호</label>
				<div class="col">
				<select name="custid">
					<c:forEach var="customer" items="${customers}">
						<option value="${customer.custid}class="form-control">${customer.name}</option>
					</c:forEach>
				</select>
			</div>	
			</div>
			<div>
			<div class="row mb-3">
				<label class="form-lable col-3">도서번호</label>
				<div class="col">
				<select name="bookid">
					<c:forEach var="book" items="${books}">
						<option value="${book.bookid}class="form-control">${book.bookname}</option>
					</c:forEach>
				</select>
			</div>
			</div>
			<div>
			<div class="row mb-3">
			<div class="col-3"></div>
					<div class="row col">
				<input type="submit" value="등록" class="btn btn-primary mb-3">
			</div>
			<div class="col-3"></div>
			</div>
		</form>
		<div class="row mb-3">
		<div class="col-3"></div>
		<div class="row col">
			<a href="list" class="btn btn-warning">목록</a>
		</div>
		<div class="col-3"></div>
	</div>
</body>
</html>
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
	<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
	integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container-fluid">
		<h1>주문내역</h1>
		<div>
			<table class="table">
				<thead class="table">
					<tr>
						<th class="col-1">주문번호</th>
						<th class="col-">고객명</th>
						<th class="col-3">도서명</th>
						<th class="">관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
							<tr>
								<td colspan="5">등록 된 고객정보가 없습니다</td>
							</tr>
					</c:if>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.orderid}</td>
							<td>${item.name}</td>
							<td>${item.bookname}</td>
							<td><a href="delete?orderid=${item.orderid}"class="btn btn-outline-danger btn-sm">삭제</a> <a href="update?orderid=${item.orderid}"class="btn btn-outline-info btn-sm">변경</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="pagination justify-content-center">
		<div>
			<a href="add" class="btn btn-primary btn-sm mb-2">등록</a>

			<a href=".." class="btn btn-warning btn-sm mb-2">처음으로</a>
		</div>
		</div>
	</div>
</body>
</html>
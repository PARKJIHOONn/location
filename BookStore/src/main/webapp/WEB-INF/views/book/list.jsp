<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h1>도서 목록</h1>
		<div class="mb-2">
			<form>
				<div class="row">
					<div class="col-2"></div>
					<div class="col-2">
				<select name="search" class="form-control form-control-sm">
					<option value="0">전체 검색</option>
					<option value="1" ${pager.search == 1 ? 'selected' : ''}>도서번호</option>
					<option value="2" ${pager.search == 2 ? 'selected' : ''}>도서명</option>
					<option value="3" ${pager.search == 3 ? 'selected' : ''}>출판사</option>
					<option value="4" ${pager.search == 4 ? 'selected' : ''}>가격</option>
				</select>
				</div>
				<div class="col-5">
				<input type="text" name="keyword" class="form-control  form-control-sm" value = "${pager.keyword}">
				</div>
				<div class="col-2">
					<input type="submit" value="검색" class="btn btn-primary btn-sm">
				</div>
				</div>
			</form>
		</div>
		<div>
			<table class="table table-sm">
				<thead class="table">
					<tr>
						<th class="col-1">도서번호</th>
						<th class="col-">도서명</th>
						<th class="col-3">출판사</th>
						<th class="col-2">가격</th>
						<th class="">관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">등록 된 도서가 없습니다</td>
						</tr>
					</c:if>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.bookid}</td>
							<td>${item.bookname}</td>
							<td>${item.publisher}</td>
							<td>${item.price}</td>
							<td><a href="delete?bookid=${item.bookid}"
								class="btn btn-outline-danger btn-sm">삭제</a> <a
								href="update?bookid=${item.bookid}"
								class="btn btn-outline-info btn-sm">변경</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						 <td colspan="5">
                     <div class="pagination justify-content-center">
                        <div class="page-item"><a href="?page=1&${pager.query}" class="page-link">처음</a></div>
                        <div class="page-item"><a href="?page=${pager.prev}&${pager.query}" class="page-link">이전</a></div>
                           <c:forEach var="page" items="${pager.list}">
                              <div class="page-item ${pager.page == page ? 'active' : ''}"><a href="?page=${page}&${pager.query}" class="page-link">${page}</a></div>
                           </c:forEach>
                        <div class="page-item"><a href="?page=${pager.next}&${pager.query}" class="page-link">다음</a></div>
                        <div class="page-item"><a href="?page=${pager.last}&${pager.query}" class="page-link">마지막</a></div>

								</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div class="pagination justify-content-center">
			<div>
				<a href="add" class="btn btn-primary btn-sm mb-2">등록</a> <a
					href="dummy" class="btn btn-primary btn-sm mb-2">대량등록</a> <a
					href="init" class="btn btn-danger btn-sm mb-2">초기화</a> <a href=".."
					class="btn btn-warning btn-sm mb-2">처음으로</a>
			</div>
		</div>
	</div>
</body>
</html>
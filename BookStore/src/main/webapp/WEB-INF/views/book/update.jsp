<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1>도서 정보 변경</h1>
		<div>
			<form method="post">
				<div class="row mb-3">
					<label class="col-3">도서번호:</label>
					<div class="col">
						<input type="number" name="bookid" value="${item.bookid}" readonly
							class="form-control">
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-3">도서명:</label>
					<div class="col">
						<input type="text" name="bookname" value="${item.bookname}"
							class="form-control">
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-3">출판사:</label>
					<div class="col">
						<input type="text" name="publisher" value="${item.publisher}"
							class="form-control">
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-3">가격:</label>
					<div class="col">
						<input type="number" name="price" value="${item.price}"
							class="form-control">
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-3"></div>
					<div class="row col">
						<input type="submit" value="변경" class="btn btn-primary">
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
		</div>
	</div>
	</div>
</body>
</html>
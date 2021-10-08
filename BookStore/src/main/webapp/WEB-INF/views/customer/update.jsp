<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1>고객정보 변경</h1>
		<div>
		<form method="post">
			<div class="row mb-3">
				<label class="col-3">고객번호:</label>
				<div class="col">
				<input type="number" name="custid" value="${item.custid}" readonly class="form-control">
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-3">고객명</label>
				<div class="col">
				<input type="text" name="name" value="${item.name}" class="form-control">
			</div>
			</div>
			<div class="row mb-3">
				<label class="col-3">주소:</label>
				<div class="col">
				<input type="text" name="address" value="${item.address}" class="form-control">
			</div>
			</div>
			<div class="row mb-3">
				<label class="col-3">전화번호:</label>
				<div class="col">
				<input type="text" name="phone" value="${item.phone}" class="form-control">
			</div>
			</div>
			<div class="row mb-3">
					<div class="col-3"></div>
					<div class="row col">
				<input type="submit" value="등록" class="btn btn-primary">
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
</body>
</html>
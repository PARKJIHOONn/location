<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<form method="post" enctype="multipart/form-data">
			<div>
				<label>카테고리명:</label>
				<input type="text" name="categoryName">
			</div>
	         <div>
	         	<label>이미지</label>
	            <input type="file" name="uploadFile">
	         </div>
			<div>
				<button>등록</button>
			</div>
		</form>
	</div>
</body>
</html>
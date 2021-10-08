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
				<label>카테고리번호:</label>
				<input type="number" name="categoryId" value="${item.categoryId}" readonly>
			</div>
			<div>
				<label>카테고리명:</label>
				<input type="text" name="categoryName" value="${item.categoryName}" >
			</div>
			 <div>
			 	  <label>기존 이미지: ${item.image}</label> 
	            <input type="file" name="uploadFile" >
	         </div>
			<div>
				<button>변경</button>
			</div>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1"> <!-- 반응형 될 수 있도록 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
   <div>
      <c:if test="${sessionScope.member == null }">
         <div>
            <a href="login">로그인</a>
         </div>
      </c:if>
      <c:if test="${sessionScope.member != null }">
         <div>
            ${sessionScope.member.name} 님 환영합니다. <a href="logout">로그아웃</a>   <!-- sessionScope : session 불러옴 -->
         </div>
      </c:if>
      <div>
         <a href="signup">회원가입</a>
      </div>

      <div>
         <ul>
            <li><a href="web/">웹서비스</a></li>
            <li><a href="member/">사용자 관리</a></li>
            <li><a href="category/">카테고리 관리</a></li>
            <li><a href="store/">가맹점 관리</a></li>
            <li><a href="product/">상품 관리</a></li>
            <li><a href="upload/">업로드 테스트</a></li>
         </ul>
      </div>
   </div>
   
</body>
</html>
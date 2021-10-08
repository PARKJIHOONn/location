<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div>
      <h3>${item.productName}</h3>
      <hr>
      <div>
         <div>가격: ${item.price}</div>
      </div>
      <div>
         <div>상품정보: </div>
         <div>${item.productInfo}</div>
      </div>
      <div>
         <div>상품 이미지: </div>
         <div>
            <ul>
               <c:forEach var="item" items="${item.productImages}">
               
                  <li><img src="/upload/files/${item.filename}"></li>
               </c:forEach>
               <c:if test="${item.productImages == null || item.productImages.size() < 1}">
                  <li>등록 된 상품 이미지가 없습니다.</li>
               </c:if>
            </ul>
         </div>
      </div>
      <div>
         <a href="..">목록</a>
      </div>
   </div>
</body>
</html>
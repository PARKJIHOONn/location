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
      <h3>상품 목록</h3>
      <div>
         <table border="1">
            <thead>
               <tr>
                  <th>상품번호</th>
                  <th>상품명</th>
                  <th>가격</th>
                  <th>관리</th>
               </tr>
            </thead>
            <tbody>
               <c:if test="${list.size() < 1}">
                  <tr>
                     <td colspan="7">등록 된 가맹점가 없습니다</td>
                  </tr>
               </c:if>
               <c:forEach var="item" items="${list}">
                  <tr>
                     <td>${item.productId}</td>
                     <td><a href="view/${item.productId}">${item.productName}</a></td>
                     <td>${item.price}</td>
                     <td><a href="delete/${item.productId}">삭제</a> <a href="update/${item.productId}">변경</a></td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
      <div>
         <a href="add">등록</a>
         <a href="..">처음으로</a>
      </div>
   </div>
</body>
</html>
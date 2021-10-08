<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
   <div>
      <h3>가맹점 등록</h3>
      <form method="post">
         <div>
            <label>가맹점명:</label> <input type="text" name="storeName">
         </div>
         <div>
            <label>전화번호:</label> <input type="text" name="tel">
         </div>
         <div>
            <label>주소:</label> <input type="text" name="address">
         </div>
         <div>
            <label>카테고리:</label> <select name="categoryId">
               <c:forEach var="category" items="${categorys}">
                  <option value="${category.categoryId}">${category.categoryName}</option>
               </c:forEach>
            </select>
         </div>
         <div>
            <label>담당자:</label> <select name="memberId">
               <c:forEach var="member" items="${members}">
                  <option value="${member.id}">${member.name}</option>
               </c:forEach>
            </select>
         </div>
         <div>
            <button>등록</button>
         </div>
      </form>
   </div>
   <div>
      <a href="list">목록</a>
   </div>
</body>
</html>
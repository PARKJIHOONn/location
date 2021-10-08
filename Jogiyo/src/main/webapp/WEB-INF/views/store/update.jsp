<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
   <div>
      <h3>가맹점 정보 변경</h3>
      <form method="post">
         <div>
            <label>가맹점번호: </label>
            <input type="text" name="storeId" value="${item.storeId}" readonly>
         </div>
         <div>
            <label>가맹점명: </label>
            <input type="text" name="storeName" value="${item.storeName}">
         </div>
         <div>
            <label>전화번호: </label>
            <input type="text" name="tel" value=${item.tel}>
         </div>
         <div>
            <label>주소: </label>
            <input type="text" name="address" value=${item.address}>
         </div>
         <div>
            <label>카테고리: </label>
            <select name="categoryId">
               <c:forEach var="category" items="${categorys}">
                  <option value="${category.categoryId}" selected="${category.categoryId == item.categoryId}">${category.categoryName}</option>
               </c:forEach>
            </select>
         </div>
         <div>
            <label>담당자: </label>
            <select name="memberId">
               <c:forEach var="member" items="${members}">
                  <option value="${member.id}" selected="${member.id == item.memberId}">${member.name}</option>
               </c:forEach>
            </select>
         </div>
         <div>
            <button>등록</button>
         </div>
      </form>
   </div>
</body>
</html>
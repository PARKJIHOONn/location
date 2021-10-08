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
      <h3>가맹점 목록</h3>
      <div>
         <table border="1">
            <thead>
               <tr>
                  <th>가맹점번호</th>
                  <th>가맹점명</th>
                  <th>전화번호</th>
                  <th>주소</th>
                  <th>카테고리</th>
                  <th>담당자</th>
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
                     <td>${item.storeId}</td>
                     <td>${item.storeName}</td>
                     <td>${item.tel}</td>
                     <td>${item.address}</td>
                     <td>${item.categoryName}</td>
                     <td>${item.memberName} (${item.memberId})</td>
                     <td><a href="delete?storeId=${item.storeId}">삭제</a> <a href="update?storeId=${item.storeId}">변경</a></td>
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
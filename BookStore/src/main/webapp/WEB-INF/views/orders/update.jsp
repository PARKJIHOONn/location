<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
      <h1>주문내역 변경</h1>
      <div>
      <form method="post">
      <div class="row mb-3">
            <label class="col-3">주문번호 : </label>
            <div class="col">
            <input type="number" name="orderid" value="${item.orderid}" readonly class="form-control">
         </div>
         </div>
         <div class="row mb-3">
            <label class="col-3">고객번호 : </label>
            <div class="col">
            <select name="custid"> 
               <c:forEach var="customer" items="${customers}">
                  <option value="${customer.custid}"class="form-control" ${item.custid == customer.custid ? 'selected' : '' }>${customer.name}</option>
               </c:forEach>
            </select>
         </div>
         </div>
         <div class="row mb-3">
            <label class="col-3">도서번호 : </label>
            <div class="col">
            <select name="bookid"> 
               <c:forEach var="book" items="${books}">
                  <option value="${book.bookid}"class="form-control" ${item.bookid == book.bookid ? 'selected' : '' }">${book.bookname}</option>
               </c:forEach>
            </select>
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
      </div>
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
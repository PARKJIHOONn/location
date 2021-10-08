<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="/js/jquery-3.6.0.min.js"></script>
<script>
   $(function() {
      $("#upload").click(function() {  						 //upload를 클릭했을 때 click실행
         const form = document.getElementById("uploadForm"); //getElementById사용이유
         const formData = new FormData(form);	        	 //-> 주어진 문자열과 일치하는 id 속성을 가진 요소를 찾고, 이를 나타내는 Element 객체를 반환합니다
         
													         //*다른방법
													         //const form = $("uploadForm");
													         //const formData = new FormData(form[0]);	
													         
         $.ajax({
            type: "POST",
            url: "upload_ajax",
            enctype: "multipart/form-data",
            data: formData,
            async: true,
            cache: false,
            contentType: false,
            processData: false,
            success: function(data){
               console.log(data);
               
               let html = "<tr><td colspan='3'><img src='/upload/files/";
               html += data;
               html += "'></td></tr>";
               
               $("tbody").append( $(html) );
            }
         });
      });
   });
</script>
</head>
<body>
   <div>
      <h3>카테고리 목록</h3>
      <div>
         <table border="1">
            <thead>
               <tr>
                  <th>카테고리번호</th>
                  <th>카테고리명</th>
                  <th>관리</th>
               </tr>
            </thead>
            <tbody>
            <c:if test="${list.size() < 1 }">
               <tr>
                  <td colspan="3">등록 된 카테고리가 없습니다.</td>
               </tr>
            </c:if>
            <c:forEach var="item" items="${list}">
               <tr>
                  <td>${item.categoryId}</td>
                  <td>${item.categoryName}</td>
                  <td><a href="delete?categoryId=${item.categoryId}">삭제</a> <a href="update?categoryId=${item.categoryId}">변경</a></td>
               </tr>
               <tr>
                     <td colspan="3"><img src="upload/files/${item.image}"></td>
               </tr>
            </c:forEach>   
            </tbody>   
         </table>
      </div>
      <div>
      <form id="uploadForm" method="post" enctype="multipart/form-data">
         <div>
            <label>카테고리:</label> 
            <input type="text" name="categoryName">
         </div>
         <div>
            <input type="file" name="uploadFile">
         </div>
         <div>
            <button>[FORM] 등록</button>
         </div>
      </form>
      </div>
      <div>
         <button id="upload">[AJAX]등록</button>
      </div>
      <div>
         <a href="..">처음으로</a>
      </div>
   </div>
</body>
</html>
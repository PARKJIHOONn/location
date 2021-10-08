<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- include libraries(jQuery, bootstrap) -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script>
   $(function() {
      $("textarea").summernote();
      
      $("#add").click(function(){
         html ="<div>";
         html += '<input type="file" name="files">';
         html += '<p class="delete">삭제</p>';
         html += '</div>';
         
         
        $("#images").append( $(html) ); 
      });
      
      $("#images").on("click", ".delete", function() {
    		$(this).parent().remove();
      });
   });
</script>
</head>
<body>
   <div>
      <h3>상품 등록</h3>
      <form method="post" enctype="multipart/form-data">
         <div>
            <label>가맹점: </label>
            <select name="storeId">
               <c:if test="${sessionScope.member.store.size() < 1}">
                  <option>등록된 가맹점 정보가 없습니다</option>
               </c:if>
               <c:forEach var="item" items="${sessionScope.member.store}">
                  <option value="${item.storeId}">${item.storeName}</option>
               </c:forEach> 
            </select>
         </div>
         <div>
            <label>상품명: </label>
            <input type="text" name="productName">
         </div>
         <div>
            <label>가격: </label>
            <input type="text" name="price">
         </div>
         <div>
            <label>상품정보: </label>
            <textarea name="productInfo" cols="60" rows="30"></textarea>
         </div>
         <div id="images">
            <label>상품이미지: </label>
            <div>
               <p id="add">추가</p>
            </div>
            <div>
               <input type="file" name="files"><p class="delete">삭제</p>
            </div>
         </div>
         <div>
            <button>등록 </button>
         </div>
      </form>
   </div>
</body>
</html>
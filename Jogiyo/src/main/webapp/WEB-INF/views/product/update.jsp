<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script>
   $(function() {
      $("textarea").summernote();
      
      $("#images").on("click", ".delete", function() {
         const productImageId = $(this).data("id");
         const button = $(this);
         $.ajax({
            type: "DELETE",
            url: location.href + "/" + productImageId, 
            success: function(data) {
               if(data == "OK") {
                  button.parent().remove();
               }
            }
         }) 
      })
   
      $("#upload").click(function() {
         const form = document.getElementById("uploadForm");
         const formData = new FormData(form);
         
         $.ajax({                                    // {} -> 객체
            type: "POST",
            url: location.href + "/image",
            enctype: "multipart/form-data",
            data: formData,
            async: true,                              // 비동기
            cache: false,
            contentType: false,
            processData: false,
            success: function(data) {
               if(data != "") {
                  let html = "<li><img src='/upload/files/";
                  html += data.filename;
                  html += "'><button class='delete' data-id='";
                  html += data.productImageId
                  html += "'>삭제</></li>";
               
                  $("#images").append( $(html) );               // tbody : tag 선택자            
               }
            }
         });                        
      });      
   });
   
</script>

</head>
<body>
   <div>
      <h3>상품정보 변경</h3>
      <form method="post">
         <div>
            <label>상품명:</label>
            <input type="text" name="productName" value="${item.productName}">
         </div>
         
         <div>
            <label>가격:</label>
            <input type="text" name="price" value="${item.price}">
         </div>
         
         <div>
            <label>상품정보:</label>
            <textarea name="productInfo" cols="60" rows="30">${item.productInfo}</textarea>
         </div>

         <div>
            <button>변경</button>
         </div>
      </form>
      
      <div>
         <ul id="images">
            <c:forEach var="item" items="${item.productImages}">
               <li><img src="/upload/files/${item.filename}"><button class="delete" data-id="${item.productImageId}">삭제</button></li>
            </c:forEach>
            <c:if test="${item.productImages == null || item.productImages.size() <1}">
               <li>등록된 상품 이미지가 없습니다.</li>
            </c:if>
         </ul>
      </div>
      
      <div>
         <div>
            <form id="uploadForm" method="post" enctype="multipart/form-data">
               <div>
                  <input type="file" name="uploadFile">
               </div>               
            </form>
         </div>
         
         <div>
            <button id="upload">[AJAX] 등록</button>
         </div>
      </div>
      
      <div>
         <a href="../list">목록</a>
      </div>
   </div>
</body>
</html>
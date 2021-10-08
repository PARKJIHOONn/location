<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
   let check_id = false;
   
   function checkId_Async() {
      const form = document.signupForm;
      
      const xhr = new XMLHttpRequest();
      
      xhr.open("GET", "checkId?id=" + form.id.value, true);
      
      xhr.onreadystatechange = function() {
         if(xhr.readyState == XMLHttpRequest.DONE) {
            if(xhr.status == 200) {
               if(xhr.responseText == "OK") {
                  check_id = true;
                  alert("[비동기] 사용가능한 회원번호 입니다.");
               } else   
                  alert("[비동기] 이미 등록 된 회원번호 입니다.");
            }
         }
      };
      
      xhr.send();
      
      console.log("결과1: " + xhr.responseText);
   }
   
   function checkId() {
      const form = document.signupForm;

      const xhr = new XMLHttpRequest();

      xhr.open("GET", "checkId?id=" + form.id.value, false);

      xhr.send();

      console.log(xhr.responseText);
      
   }
   function signup() {
      const form = document.signupForm;
      
      if(form.id.value == '') {
         alert('아이디를 입력 해 주세요');
         form.id.focus();
         return;
      }
      
      if(!check_id){
       alert('아이디 중복 검사를 해 주세요');
       return;
      }
      
      if(form.passwd.value == ''){
         alert('비밀번호를 입력 해 주세요');
         form.passwd.focus();
         return;
      }
      if(form.passwd_check.value == ''){
         alert('비밀번호 확인을 입력 해 주세요');
         form.passwd.focus();
         return;
      }
      if(form.passwd.value !== form.passwd_check.value ){
         alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
         form.passwd_check.focus();
         return;
      }
      if(form.name.value == ''){
         alert('성명을 입력 해 주세요');
         form.name.focus();
         return;
      }
      if(form.address.value == ''){
         alert('주소를 입력 해 주세요');
         form.address.focus();
         return;   
      }
      if(form.tel.value == ''){
         alert('전화번호를 입력 해 주세요');
         form.tel.focus();
         return;
      }
      form.submit();
   }
   function changeId(){
      check_id = false;
   }
   function goBack(){
      //history.back();
      location.href = ".";
   }
</script>
</head>
<body>
   <div>
      <h3>회원가입</h3>
      <div>
         <form name="signupForm" method="post">
            <div>
               <label>아이디:</label>
               <input type="text" name="id" onchange="changeId()"><div onclick="checkId_Async()">중복확인</div>
            </div>
            <div>
               <label>비밀번호:</label>
               <input type="password" name="passwd">
            </div>
            <div>
               <label>비밀번호 확인:</label>
               <input type="password" name="passwd_check">
            </div>
            <div>
               <label>성명:</label>
               <input type="text" name="name">
            </div>
            <div>
               <label>주소:</label>
               <input type="text" name="address">
            </div>
            <div>
               <label>전화번호:</label>
               <input type="text" name="tel">
            </div>
         </form>
         <div>
               <button onclick="signup()">회원가입</button> <button onclick="goBack()">취소</button>
         </div>
      </div>
   </div>
</body>
</html>
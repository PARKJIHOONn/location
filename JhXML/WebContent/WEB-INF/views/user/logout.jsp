<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="#{pageContext.request.contextPath}/"/>
<script>
	alert("로그아웃 되었습니다.")
	location.href = "${root}main" //location.href를 호출한 페이지로 이동
</script>

</body>
</html>








